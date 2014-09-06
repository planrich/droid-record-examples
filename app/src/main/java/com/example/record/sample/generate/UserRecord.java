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
package com.example.record.sample.generate;

import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.database.Cursor;
import at.pasra.record.SQLiteConverter;

public class UserRecord{
    private final java.util.Map<Long, User> primaryKeyCache = new java.util.HashMap<Long, User>();
    public void clearCache(){
        primaryKeyCache.clear();
    }
    public void save(SQLiteDatabase db, AbstractUser record){
        if (record.getId() == null){
            insert(db, record);
        }
        else{
            update(db, record);
        }
    }
    public void insert(SQLiteDatabase db, AbstractUser record){
        ContentValues values = new ContentValues(2);
        values.put("first_name", record.getFirstName());
        values.put("last_name", record.getLastName());
        long id = db.insert("users", null, values);
        record.setId(id);
        primaryKeyCache.put(id, (User)record);
    }
    public User load(SQLiteDatabase db, long id){
        User cached = primaryKeyCache.get(id);
        if (cached != null){
            return cached;
        }
        Cursor c = db.rawQuery("select first_name, last_name, _id from users where _id = ?;", new String[] { Long.toString(id) });
        if (c.moveToFirst()){
            User record = new User();
            record.setFirstName(c.getString(c.getColumnIndex("first_name")));
            record.setLastName(c.getString(c.getColumnIndex("last_name")));
            record.setId(c.getLong(c.getColumnIndex("_id")));
            primaryKeyCache.put(id, record);
            return record;
        }
        return null;
    }
    public void delete(SQLiteDatabase db, long id){
        db.execSQL("delete from users where  _id = ?;", new String[] { Long.toString(id) });
        primaryKeyCache.remove(id);
    }
    public void update(SQLiteDatabase db, AbstractUser record){
        ContentValues values = new ContentValues(2);
        values.put("first_name", record.getFirstName());
        values.put("last_name", record.getLastName());
        long id = record.getId();
        db.update("users", values, "_id = ?", new String[] { Long.toString(id) });
    }
}
