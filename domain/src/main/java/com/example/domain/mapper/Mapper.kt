package com.example.domain.mapper

interface Mapper<Entity, Model> {
    fun transform(entity: Entity): Model
}