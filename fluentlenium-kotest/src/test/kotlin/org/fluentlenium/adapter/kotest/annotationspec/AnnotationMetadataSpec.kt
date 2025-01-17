package org.fluentlenium.adapter.kotest.annotationspec

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import org.fluentlenium.adapter.exception.AnnotationNotFoundException
import org.fluentlenium.adapter.kotest.FluentAnnotationSpec
import org.fluentlenium.adapter.kotest.MyAnnotation
import org.fluentlenium.adapter.kotest.OtherAnnotation

@MyAnnotation
class AnnotationMetadataSpec : FluentAnnotationSpec() {

    @Test
    fun testClass() {
        testClass shouldBe javaClass
    }

    @Test
    fun testMethodName() {
        testMethodName shouldBe "testMethodName"
    }

    @Test
    fun testGetClassAnnotation() {
        getClassAnnotation(MyAnnotation::class.java).shouldNotBeNull()

        shouldThrow<AnnotationNotFoundException> {
            getClassAnnotation(OtherAnnotation::class.java).shouldNotBeNull()
        }
    }

    @Test
    @MyAnnotation
    fun testGetMethodAnnotation() {
        getMethodAnnotation(MyAnnotation::class.java).shouldNotBeNull()

        shouldThrow<AnnotationNotFoundException> {
            getMethodAnnotation(OtherAnnotation::class.java).shouldNotBeNull()
        }
    }
}
