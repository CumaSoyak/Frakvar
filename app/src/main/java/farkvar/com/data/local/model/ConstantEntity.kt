package farkvar.com.data.local.model

import androidx.room.*

@Entity(tableName = "ConstantTable")
class ConstantEntity(
    var bayiUzaklik: Int,
    var gelAlIndirimi: Int,
    var kargoUcreti: Int,
    var kuryeCheckinUzaklik: Int,
    var mesaiSaati: String,
    var perakendeGonderimIndirimi: Int,
    var perakendeHediye: String,
    var perakendeHediyeLimit: Int,
    var perakendeMinGonderimTutari: Int,
    var toptanGonderimIndirimi: Int,
    var toptanHediye: String,
    var toptanHediyeLimit: Int,
    var toptanMinGonderimTutari: Int
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var constantId: Int = 0
}