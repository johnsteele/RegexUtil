/*
 * Copyright 2006 Sascha Weinreuter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ess.regexutil.gwt.regexEditor.client.lexer;

import com.ess.regexutil.gwt.psi.client.lexer.FlexAdapter ;

import java.util.EnumSet;

public class RegexLexer extends FlexAdapter {

    private static final int COMMENT_MODE = 1 << 14;
    private final EnumSet<RegexCapability> myCapabilities;

    public RegexLexer(EnumSet<RegexCapability> capabilities) {
        super(new _RegExLexer(capabilities));
        myCapabilities = capabilities;
  }

    public void start(String buffer, int startOffset, int endOffset, int initialState) {
        getFlex().commentMode = (initialState & COMMENT_MODE) != 0 || myCapabilities.contains(RegexCapability.COMMENT_MODE);
        super.start(buffer, startOffset, endOffset, initialState & ~COMMENT_MODE);
    }

    public _RegExLexer getFlex() {
        return (_RegExLexer)super.getFlex();
    }

    public int getState() {
        final boolean commentMode = getFlex().commentMode;
        final int state = super.getState();
        return commentMode ? state | COMMENT_MODE : state;
    }
}
