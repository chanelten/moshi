/*
 * Copyright (C) 2015 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.squareup.moshi;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Customizes how a field is encoded as JSON.
 *
 * <p>Although this annotation doesn't declare a {@link Target}, it is only honored in the following
 * elements:
 *
 * <ul>
 *   <li><strong>Java class fields</strong>
 *   <li><strong>Kotlin properties</strong> for use with {@code moshi-kotlin} or {@code
 *       moshi-kotlin-codegen}. This includes both properties declared in the constructor and
 *       properties declared as members.
 * </ul>
 *
 * <p>Users of the <a href="https://github.com/rharter/auto-value-moshi">AutoValue: Moshi
 * Extension</a> may also use this annotation on abstract getters.
 */
@Retention(RUNTIME)
@Documented
public @interface Json {
  /** The default value of {@link #name()}. Should only be used to check if it's been set. */
  String UNSET_NAME = "\u0000";

  /** The name of the field when encoded as JSON. */
  String name() default UNSET_NAME;

  /**
   * If true, this field/property will be ignored. This is semantically similar to use of {@code
   * transient} on the JVM.
   *
   * <p><strong>Note:</strong> this has no effect in enums or record classes.
   */
  boolean ignore() default false;
}
