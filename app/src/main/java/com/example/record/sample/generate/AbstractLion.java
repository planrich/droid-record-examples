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
// This file is generated. If you want to save you some time: !!!DO NOT MODIFY!!!
package com.example.record.sample.generate;

import com.example.record.sample.domain.Lion;
import at.pasra.record.RecordBuilder;

public class AbstractLion{
    protected java.lang.Integer mLegs;
    protected java.lang.Double mSize;
    protected java.lang.Long mId;
    
    public AbstractLion(java.lang.Long id){
        this.mId = id;
        this.mLegs = new Integer(20);
        this.mSize = 333.3232;
    }
    
    public java.lang.Integer getLegs() { return mLegs; }
    public void setLegs(java.lang.Integer value) { mLegs = value; }
    public java.lang.Double getSize() { return mSize; }
    public void setSize(java.lang.Double value) { mSize = value; }
    public java.lang.Long getId() { return mId; }
    public void setId(java.lang.Long value) { mId = value; }
    public static Lion fromCursor(android.database.Cursor cursor){
        Lion record = new Lion();
        record.setLegs(cursor.getInt(cursor.getColumnIndex("legs")));
        record.setSize(Double.longBitsToDouble(cursor.getLong(cursor.getColumnIndex("size"))));
        record.setId(cursor.getLong(cursor.getColumnIndex("_id")));
        return record;
    }
}
