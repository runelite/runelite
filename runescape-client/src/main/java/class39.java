import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public class class39 {
   @ObfuscatedName("a")
   public final Coordinates field547;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 603456755
   )
   public final int field548;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1498669247
   )
   int field549;
   @ObfuscatedName("w")
   public final Coordinates field550;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 626045137
   )
   final int field551;
   @ObfuscatedName("r")
   final class33 field553;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1362547145
   )
   final int field554;
   @ObfuscatedName("c")
   static int[][][] field555;
   @ObfuscatedName("rt")
   static GarbageCollectorMXBean field558;
   @ObfuscatedName("m")
   public static Buffer field559;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1045903997
   )
   int field560;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIZB)Ljava/lang/String;",
      garbageValue = "-60"
   )
   static String method547(int var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         if(var2 && var0 >= 0) {
            int var3 = 2;

            for(int var4 = var0 / var1; var4 != 0; ++var3) {
               var4 /= var1;
            }

            char[] var5 = new char[var3];
            var5[0] = 43;

            for(int var6 = var3 - 1; var6 > 0; --var6) {
               int var7 = var0;
               var0 /= var1;
               int var8 = var7 - var0 * var1;
               if(var8 >= 10) {
                  var5[var6] = (char)(var8 + 87);
               } else {
                  var5[var6] = (char)(var8 + 48);
               }
            }

            return new String(var5);
         } else {
            return Integer.toString(var0, var1);
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1435385170"
   )
   boolean method549(int var1, int var2) {
      Area var3 = Area.field3303[this.field548];
      switch(var3.field3311.field3550) {
      case 0:
         if(var1 >= this.field549 && var1 < this.field551 + this.field549) {
            break;
         }

         return false;
      case 1:
         if(var1 >= this.field549 - this.field551 / 2 && var1 <= this.field551 / 2 + this.field549) {
            break;
         }

         return false;
      case 2:
         if(var1 <= this.field549 - this.field551 || var1 > this.field549) {
            return false;
         }
      }

      switch(var3.field3309.field3282) {
      case 0:
         if(var2 >= this.field560 - this.field554 / 2 && var2 <= this.field554 / 2 + this.field560) {
            break;
         }

         return false;
      case 1:
         if(var2 <= this.field560 - this.field554 || var2 > this.field560) {
            return false;
         }
         break;
      case 2:
         if(var2 < this.field560 || var2 >= this.field554 + this.field560) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "71"
   )
   boolean method550(int var1, int var2) {
      return this.field553 == null?false:(var1 >= this.field549 - this.field553.field475 / 2 && var1 <= this.field549 + this.field553.field475 / 2?var2 >= this.field560 && var2 <= this.field560 + this.field553.field477:false);
   }

   class39(int var1, Coordinates var2, Coordinates var3, class33 var4) {
      this.field548 = var1;
      this.field547 = var2;
      this.field550 = var3;
      this.field553 = var4;
      Area var5 = Area.field3303[this.field548];
      SpritePixels var6 = var5.method4291(false);
      if(var6 != null) {
         this.field551 = var6.width;
         this.field554 = var6.height;
      } else {
         this.field551 = 0;
         this.field554 = 0;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "6"
   )
   boolean method551(int var1, int var2) {
      return this.method549(var1, var2)?true:this.method550(var1, var2);
   }

   @ObfuscatedName("jc")
   @ObfuscatedSignature(
      signature = "(LWidget;B)Z",
      garbageValue = "2"
   )
   static boolean method555(Widget var0) {
      if(Client.field1097) {
         if(WorldMapType3.method199(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }

   @ObfuscatedName("jx")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1799943772"
   )
   static void method556(Buffer var0, int var1) {
      byte[] var2 = var0.payload;
      if(Client.field961 == null) {
         Client.field961 = new byte[24];
      }

      class183.method3449(var2, var1, Client.field961, 0, 24);
      if(class155.field2258 != null) {
         try {
            class155.field2258.method2338(0L);
            class155.field2258.method2339(var0.payload, var1, 24);
         } catch (Exception var4) {
            ;
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "992557555"
   )
   static final int method557(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "843464415"
   )
   static int method559(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = PacketBuffer.method3403(class83.intStack[--class46.intStackSize]);
      } else {
         var3 = var2?class83.field1364:class60.field766;
      }

      int var4;
      if(var0 == 1300) {
         var4 = class83.intStack[--class46.intStackSize] - 1;
         if(var4 >= 0 && var4 <= 9) {
            var3.method3992(var4, class83.scriptStringStack[--class50.scriptStringStackSize]);
            return 1;
         } else {
            --class50.scriptStringStackSize;
            return 1;
         }
      } else if(var0 == 1301) {
         class46.intStackSize -= 2;
         var4 = class83.intStack[class46.intStackSize];
         int var5 = class83.intStack[class46.intStackSize + 1];
         var3.dragParent = class202.method3650(var4, var5);
         return 1;
      } else if(var0 == 1302) {
         var3.field2737 = class83.intStack[--class46.intStackSize] == 1;
         return 1;
      } else if(var0 == 1303) {
         var3.field2730 = class83.intStack[--class46.intStackSize];
         return 1;
      } else if(var0 == 1304) {
         var3.field2720 = class83.intStack[--class46.intStackSize];
         return 1;
      } else if(var0 == 1305) {
         var3.name = class83.scriptStringStack[--class50.scriptStringStackSize];
         return 1;
      } else if(var0 == 1306) {
         var3.selectedAction = class83.scriptStringStack[--class50.scriptStringStackSize];
         return 1;
      } else if(var0 == 1307) {
         var3.actions = null;
         return 1;
      } else {
         return 2;
      }
   }
}
