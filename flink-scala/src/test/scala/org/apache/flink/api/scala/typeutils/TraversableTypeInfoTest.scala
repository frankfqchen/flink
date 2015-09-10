/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.api.scala.typeutils

import org.apache.flink.api.common.ExecutionConfig
import org.apache.flink.api.common.typeinfo.{TypeInformation, BasicTypeInfo}
import org.apache.flink.api.common.typeutils.TypeSerializer
import org.apache.flink.util.TestLogger
import org.junit.Test
import org.scalatest.junit.JUnitSuiteLike

class TraversableTypeInfoTest extends TestLogger with JUnitSuiteLike {

  @Test
  def testTraversableTypeInfoEquality(): Unit = {
    val tpeInfo1 = new TraversableTypeInfo[Seq[Int], Int](
      classOf[Seq[Int]],
      BasicTypeInfo.INT_TYPE_INFO.asInstanceOf[TypeInformation[Int]]) {
      override def createSerializer(executionConfig: ExecutionConfig): TypeSerializer[Seq[Int]] =
        ???
    }

    val tpeInfo2 = new TraversableTypeInfo[Seq[Int], Int](
      classOf[Seq[Int]],
      BasicTypeInfo.INT_TYPE_INFO.asInstanceOf[TypeInformation[Int]]) {
      override def createSerializer(executionConfig: ExecutionConfig): TypeSerializer[Seq[Int]] =
        ???
    }

    assert(tpeInfo1.equals(tpeInfo2))
  }

  @Test
  def testTraversableTypeInfoInequality(): Unit = {
    val tpeInfo1 = new TraversableTypeInfo[Seq[Int], Int](
      classOf[Seq[Int]],
      BasicTypeInfo.INT_TYPE_INFO.asInstanceOf[TypeInformation[Int]]) {
      override def createSerializer(executionConfig: ExecutionConfig): TypeSerializer[Seq[Int]] =
        ???
    }

    val tpeInfo2 = new TraversableTypeInfo[List[Int], Int](
      classOf[List[Int]],
      BasicTypeInfo.INT_TYPE_INFO.asInstanceOf[TypeInformation[Int]]) {
      override def createSerializer(executionConfig: ExecutionConfig): TypeSerializer[List[Int]] =
        ???
    }

    assert(!tpeInfo1.equals(tpeInfo2))
  }

}