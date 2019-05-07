/*
 * Copyright (c) 2018, https://runelitepl.us
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.autoprayerswitch;

import net.runelite.api.widgets.WidgetInfo;

public enum Prayer
{
  PROTECT_FROM_MELEE(net.runelite.api.Prayer.PROTECT_FROM_MELEE, "Protect from Melee", WidgetInfo.PRAYER_PROTECT_FROM_MELEE.getId()),  PROTECT_FROM_MAGIC(net.runelite.api.Prayer.PROTECT_FROM_MAGIC, "Protect from Magic", WidgetInfo.PRAYER_PROTECT_FROM_MAGIC.getId()),  PROTECT_FROM_MISSILES(net.runelite.api.Prayer.PROTECT_FROM_MISSILES, "Protect from Missiles", WidgetInfo.PRAYER_PROTECT_FROM_MISSILES.getId());
  
  private final net.runelite.api.Prayer prayer;
  private final String name;
  private final int widgetId;
  
  private Prayer(net.runelite.api.Prayer prayer, String name, int widgetId)
  {
    this.prayer = prayer;this.name = name;this.widgetId = widgetId;
  }
  
  public net.runelite.api.Prayer getPrayer()
  {
    return this.prayer;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getWidgetId()
  {
    return this.widgetId;
  }
}
