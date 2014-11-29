/* Copyright (c) 2013, Richard Plangger <rich@pasra.at> All rights reserved.
 *
 * Android Record version 0.1.4 generated this file. For more
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
package com.example.record.sample.generate;

import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.database.Cursor;
import com.example.record.sample.domain.Gallery;

public class GalleryRecord{
    private final java.util.Map<Long, Gallery> primaryKeyCache = new java.util.HashMap<Long, Gallery>();
    public void clearCache(){
        primaryKeyCache.clear();
    }
    public void save(SQLiteDatabase db, AbstractGallery record){
        if (record.getId() == null){
            insert(db, record);
        }
        else{
            update(db, record);
        }
    }
    public void insert(SQLiteDatabase db, AbstractGallery record){
        ContentValues values = new ContentValues(2);
        values.put("name", record.getName());
        values.put("user_id", record.getUserId());
        long id = db.insert("galleries", null, values);
        record.setId(id);
        primaryKeyCache.put(id, (Gallery)record);
    }
    public Gallery load(SQLiteDatabase db, long id){
        Gallery cached = primaryKeyCache.get(id);
        if (cached != null){
            return cached;
        }
        Cursor c = db.rawQuery("select name, _id, user_id from galleries where _id = ?;", new String[] { Long.toString(id) });
        if (c.moveToFirst()){
            Gallery record = new Gallery();
            record.setName(c.getString(c.getColumnIndex("name")));
            record.setId(c.getLong(c.getColumnIndex("_id")));
            record.setUserId(c.getLong(c.getColumnIndex("user_id")));
            primaryKeyCache.put(id, record);
            return record;
        }
        return null;
    }
    public void delete(SQLiteDatabase db, long id){
        db.execSQL("delete from galleries where  _id = ?;", new String[] { Long.toString(id) });
        primaryKeyCache.remove(id);
    }
    public void update(SQLiteDatabase db, AbstractGallery record){
        ContentValues values = new ContentValues(2);
        values.put("name", record.getName());
        values.put("user_id", record.getUserId());
        long id = record.getId();
        db.update("galleries", values, "_id = ?", new String[] { Long.toString(id) });
    }
}
