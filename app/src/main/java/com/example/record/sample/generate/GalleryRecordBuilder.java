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

import at.pasra.record.RecordBuilder;
import android.database.sqlite.SQLiteDatabase;

public class GalleryRecordBuilder extends RecordBuilder<Gallery>{
    public GalleryRecordBuilder(SQLiteDatabase db){
        super("galleries", new String[] { "name", "_id", "user_id" }, db);
    }
    @Override
    public java.util.List<Gallery> all(android.database.Cursor c){
        java.util.List<Gallery> list = new java.util.ArrayList<Gallery>();
        while (c.moveToNext()){
            list.add(Gallery.fromCursor(c));
        }
        return list;
    }
    @Override
    public Gallery first(android.database.Cursor c){
        if (c.moveToFirst()){
            Gallery record = Gallery.fromCursor(c);
            c.close();
            return record;
        }
        c.close();
        return null;
    }
}
