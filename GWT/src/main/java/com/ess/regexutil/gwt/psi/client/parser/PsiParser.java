/*
 * Copyright 2000-2009 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ess.regexutil.gwt.psi.client.parser;

import com.ess.regexutil.gwt.psi.client.PsiFile;

/**
 * The plugin side of a custom language parser. Receives tokens returned from
 * lexer and builds an AST tree out of them.
 */

public interface PsiParser {
  /**
   * Parses the contents of the specified PSI builder and returns an AST tree with the
   * specified type of root element. The PSI builder contents is the entire file
   * or (if chameleon tokens are used) the text of a chameleon token which needs to
   * be reparsed.
   *
   * @param builder the builder which is used to retrieve the original file tokens and build the AST tree.
   * @return the root of the resulting AST tree.
   */
//  @NotNull
  PsiFile parse(PsiBuilder builder);
}
