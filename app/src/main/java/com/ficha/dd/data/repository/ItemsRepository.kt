package com.ficha.dd.data.repository

import com.ficha.dd.domain.model.Item

interface ItemsRepository {
    abstract fun getAllItems(): List<Item>?

}
