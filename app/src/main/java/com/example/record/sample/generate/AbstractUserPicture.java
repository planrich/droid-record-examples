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

public class AbstractUserPicture{
    protected java.lang.Long mUserId;
    protected java.lang.Long mPictureId;
    protected java.lang.Long mId;
    
    public AbstractUserPicture(java.lang.Long id){
        this.mId = id;
        this.mUserId = new Long(0L);
        this.mPictureId = new Long(0L);
    }
    
    public java.lang.Long getUserId() { return mUserId; }
    public void setUserId(java.lang.Long value) { mUserId = value; }
    public java.lang.Long getPictureId() { return mPictureId; }
    public void setPictureId(java.lang.Long value) { mPictureId = value; }
    public java.lang.Long getId() { return mId; }
    public void setId(java.lang.Long value) { mId = value; }
    public static UserPicture of(User user, Picture picture){
        UserPicture obj = new UserPicture();
        obj.setUserId(user.getId());
        obj.setPictureId(picture.getId());
        return obj;
    }
    public static UserPicture of(Picture picture, User user){
        UserPicture obj = new UserPicture();
        obj.setPictureId(picture.getId());
        obj.setUserId(user.getId());
        return obj;
    }
    public static UserPicture fromCursor(android.database.Cursor cursor){
        UserPicture record = new UserPicture();
        record.setUserId(cursor.getLong(cursor.getColumnIndex("user_id")));
        record.setPictureId(cursor.getLong(cursor.getColumnIndex("picture_id")));
        record.setId(cursor.getLong(cursor.getColumnIndex("_id")));
        return record;
    }
}
