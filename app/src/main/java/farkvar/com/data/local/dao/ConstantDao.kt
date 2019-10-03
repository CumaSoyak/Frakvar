package farkvar.com.data.local.dao

import androidx.room.Dao
import androidx.room.Query
 import farkvar.com.data.local.dao.base.BaseDao
import farkvar.com.data.local.model.ConstantEntity


@Dao
interface ConstantDao : BaseDao<ConstantEntity> {
    @Query("DELETE FROM ConstantTable")
    fun delete()

    @get:Query("SELECT * FROM ConstantTable")
    val constants: ConstantEntity
}