package br.com.douglas.ioasysfigman.data_remote.mappers

import br.com.douglas.ioasysfigman.data_remote.model.BookResponse
import br.com.douglas.ioasysfigman.domain.model.Book

fun List<BookResponse>.toDomain(): List<Book>{
    return this.map{
        Book(
            id = it.id?:"",
            name = it.name?:"",
            author = it.author?.first()?:"",
            pages = it.pages?:"",
            editor = it.editor?:"",
            originName = it.originName?:"",
            date = it.date?:"",
            isbn10 = it.isbn10?:"",
            isbn13 = it.isbn13?:"",
            language = it.language?:"",
            imageUrl =  it.imageUrl?:""
        )
    }
}