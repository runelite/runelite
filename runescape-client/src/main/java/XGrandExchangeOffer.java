import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
@Implements("XGrandExchangeOffer")
public class XGrandExchangeOffer {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1047951645
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 619657883
   )
   @Export("price")
   public int price;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2108035087
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 715828327
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1829979075
   )
   @Export("spent")
   public int spent;
   @ObfuscatedName("oa")
   @ObfuscatedGetter(
      intValue = 1585710679
   )
   static int field47;
   @ObfuscatedName("an")
   static int[] field48;
   @ObfuscatedName("x")
   @Export("progress")
   byte progress;
   @ObfuscatedName("dz")
   @Export("xteaKeys")
   static int[][] xteaKeys;

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "0"
   )
   public XGrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.readInt();
      this.totalQuantity = var1.readInt();
      this.quantitySold = var1.readInt();
      this.spent = var1.readInt();
   }

   public XGrandExchangeOffer() {
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "106"
   )
   public int method51() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "529996180"
   )
   void method52(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-134543151"
   )
   void method53(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "8"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[class31.plane][var0][var1];
      if(var2 == null) {
         Friend.region.method1774(class31.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.method2448(); var6 != null; var6 = (Item)var2.method2445()) {
            ItemComposition var7 = class154.getItemDefinition(var6.id);
            long var8 = (long)var7.price;
            if(var7.isStackable == 1) {
               var8 *= (long)(var6.quantity + 1);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(null == var5) {
            Friend.region.method1774(class31.plane, var0, var1);
         } else {
            var2.method2444(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.method2448(); null != var6; var6 = (Item)var2.method2445()) {
               if(var6.id != var5.id) {
                  if(var11 == null) {
                     var11 = var6;
                  }

                  if(var11.id != var6.id && null == var10) {
                     var10 = var6;
                  }
               }
            }

            int var9 = 1610612736 + var0 + (var1 << 7);
            Friend.region.method1779(class31.plane, var0, var1, class1.method21(var0 * 128 + 64, 64 + 128 * var1, class31.plane), var5, var9, var11, var10);
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass159;B)V",
      garbageValue = "42"
   )
   static final void method58(CipherBuffer var0) {
      int var1 = 0;
      var0.method3085();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < class45.field934; ++var2) {
         var3 = class45.field925[var2];
         if((class45.field921[var3] & 1) == 0) {
            if(var1 > 0) {
               --var1;
               class45.field921[var3] = (byte)(class45.field921[var3] | 2);
            } else {
               var4 = var0.method3097(1);
               if(var4 == 0) {
                  var1 = class47.method954(var0);
                  class45.field921[var3] = (byte)(class45.field921[var3] | 2);
               } else {
                  class162.method3123(var0, var3);
               }
            }
         }
      }

      var0.method3082();
      if(var1 != 0) {
         throw new RuntimeException();
      } else {
         var0.method3085();

         for(var2 = 0; var2 < class45.field934; ++var2) {
            var3 = class45.field925[var2];
            if((class45.field921[var3] & 1) != 0) {
               if(var1 > 0) {
                  --var1;
                  class45.field921[var3] = (byte)(class45.field921[var3] | 2);
               } else {
                  var4 = var0.method3097(1);
                  if(var4 == 0) {
                     var1 = class47.method954(var0);
                     class45.field921[var3] = (byte)(class45.field921[var3] | 2);
                  } else {
                     class162.method3123(var0, var3);
                  }
               }
            }
         }

         var0.method3082();
         if(var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.method3085();

            for(var2 = 0; var2 < class45.field926; ++var2) {
               var3 = class45.field927[var2];
               if((class45.field921[var3] & 1) != 0) {
                  if(var1 > 0) {
                     --var1;
                     class45.field921[var3] = (byte)(class45.field921[var3] | 2);
                  } else {
                     var4 = var0.method3097(1);
                     if(var4 == 0) {
                        var1 = class47.method954(var0);
                        class45.field921[var3] = (byte)(class45.field921[var3] | 2);
                     } else if(class15.method201(var0, var3)) {
                        class45.field921[var3] = (byte)(class45.field921[var3] | 2);
                     }
                  }
               }
            }

            var0.method3082();
            if(var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.method3085();

               for(var2 = 0; var2 < class45.field926; ++var2) {
                  var3 = class45.field927[var2];
                  if((class45.field921[var3] & 1) == 0) {
                     if(var1 > 0) {
                        --var1;
                        class45.field921[var3] = (byte)(class45.field921[var3] | 2);
                     } else {
                        var4 = var0.method3097(1);
                        if(var4 == 0) {
                           var1 = class47.method954(var0);
                           class45.field921[var3] = (byte)(class45.field921[var3] | 2);
                        } else if(class15.method201(var0, var3)) {
                           class45.field921[var3] = (byte)(class45.field921[var3] | 2);
                        }
                     }
                  }
               }

               var0.method3082();
               if(var1 != 0) {
                  throw new RuntimeException();
               } else {
                  class45.field934 = 0;
                  class45.field926 = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     class45.field921[var2] = (byte)(class45.field921[var2] >> 1);
                     Player var5 = Client.cachedPlayers[var2];
                     if(null != var5) {
                        class45.field925[++class45.field934 - 1] = var2;
                     } else {
                        class45.field927[++class45.field926 - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-959222102"
   )
   public static void method63(int var0) {
      if(class138.field1920 != 0) {
         Ignore.field245 = var0;
      } else {
         class138.field1919.method2566(var0);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-629516190"
   )
   public static String method64(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            var5 = FileOnDisk.method1492(var5);
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != 46 && var5 != 63 && var5 != 33) {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }

   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      signature = "(LWidgetNode;ZI)V",
      garbageValue = "2040272568"
   )
   static final void method65(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      int var5;
      if(var1 && var2 != -1 && NPC.validInterfaces[var2]) {
         Widget.field2269.method3318(var2);
         if(null != Widget.widgets[var2]) {
            boolean var4 = true;

            for(var5 = 0; var5 < Widget.widgets[var2].length; ++var5) {
               if(Widget.widgets[var2][var5] != null) {
                  if(Widget.widgets[var2][var5].type != 2) {
                     Widget.widgets[var2][var5] = null;
                  } else {
                     var4 = false;
                  }
               }
            }

            if(var4) {
               Widget.widgets[var2] = null;
            }

            NPC.validInterfaces[var2] = false;
         }
      }

      CipherBuffer.method3081(var2);
      Widget var6 = World.method670(var3);
      if(null != var6) {
         class2.method36(var6);
      }

      ScriptState.method171();
      if(Client.widgetRoot != -1) {
         var5 = Client.widgetRoot;
         if(class44.method892(var5)) {
            CombatInfo1.method628(Widget.widgets[var5], 1);
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1513063672"
   )
   public int method66() {
      return this.progress & 7;
   }
}
