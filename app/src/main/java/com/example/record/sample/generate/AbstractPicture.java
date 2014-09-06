/* Copyright (c) 2013, Richard Plangger <rich@pasra.at> All rights reserved.
 *
 * Android Record version 0.1.0 generated this file. For more
 * information see http://record.pasra.at/
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS
 * OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY
 * AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 *
 * This copyright notice must not be modified or deleted.
 */
// This file is generated. If you want to save you some time: !!!DO NOT MODIFY!!!
package com.example.record.sample.generate;

import at.pasra.record.SQLiteConverter;
import at.pasra.record.RecordBuilder;

public class AbstractPicture{
    protected java.lang.String mName;
    protected byte[] mImage;
    protected java.util.Date mDate;
    protected java.lang.Long mGalleryId;
    protected java.lang.Long mId;
    
    public AbstractPicture(java.lang.Long id){
        this.mId = id;
        this.mName = "";
        this.mImage = new byte[0];
        this.mDate = new java.util.Date(0);
        this.mGalleryId = new Long(0L);
    }
    
    public java.lang.String getName() { return mName; }
    public void setName(java.lang.String value) { mName = value; }
    public byte[] getImage() { return mImage; }
    public void setImage(byte[] value) { mImage = value; }
    public java.util.Date getDate() { return mDate; }
    public void setDate(java.util.Date value) { mDate = value; }
    public java.lang.Long getGalleryId() { return mGalleryId; }
    public void setGalleryId(java.lang.Long value) { mGalleryId = value; }
    public java.lang.Long getId() { return mId; }
    public void setId(java.lang.Long value) { mId = value; }
    public Gallery loadGallery(LocalSession session){
        return session.findGallery(this.getId());
    }
    public java.util.List<User> loadUsers(LocalSession session){
        String query = "select d.* from pictures o, user_pictures t, users d" +
                       " where" +
                       " o._id = ? and" +
                       " o._id = t.picture_id and" +
                       " d._id = t.user_id";
        android.database.Cursor c = session.queryRaw(query, Long.toString(mId));
        RecordBuilder<User> rb = session.queryUsers();
        return rb.all(c);
    }
    public static Picture of(Gallery obj0){
        Picture obj = new Picture();
        obj.setGalleryId(obj0.getId());
        return obj;
    }
    public static Picture fromCursor(android.database.Cursor cursor){
        Picture record = new Picture();
        record.setName(cursor.getString(cursor.getColumnIndex("name")));
        record.setImage(cursor.getBlob(cursor.getColumnIndex("image")));
        record.setDate(new java.util.Date(cursor.getLong(cursor.getColumnIndex("date"))));
        record.setGalleryId(cursor.getLong(cursor.getColumnIndex("gallery_id")));
        record.setId(cursor.getLong(cursor.getColumnIndex("_id")));
        return record;
    }
}
