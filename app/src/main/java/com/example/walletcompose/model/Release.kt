package com.example.walletcompose.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.walletcompose.model.enums.ReleaseType
import java.math.BigDecimal

 /**
 * @Author:  Vitor Rey
 * @Date: 29,maio,2023
 * @Email: vitorrey.dev@gmail.com
 **/

 @Entity(tableName = "releases")
data class Release(
     @PrimaryKey(autoGenerate = true) val id: Int,
     @ColumnInfo(name = "description") val description: String,
     @ColumnInfo(name = "type") val type: ReleaseType,
     //@ColumnInfo(name = "amount") val amount: BigDecimal,
     @ColumnInfo(name = "payment_status") val paymentStatus: Boolean
)
