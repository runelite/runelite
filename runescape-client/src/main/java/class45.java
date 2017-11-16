import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public class class45 extends class28 {
   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("indexTrack1")
   static IndexData indexTrack1;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = 250347741
   )
   @Export("cameraX")
   static int cameraX;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = -1113969959
   )
   @Export("cameraPitch")
   static int cameraPitch;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1119638879
   )
   int field548;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 809635853
   )
   int field546;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1854937729
   )
   int field543;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 429488977
   )
   int field544;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lfs;Lfs;B)V",
      garbageValue = "86"
   )
   void method602(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field465.field464) {
         throw new IllegalStateException("");
      } else {
         super.field388 = var2.readUnsignedByte();
         super.field380 = var2.readUnsignedByte();
         super.field386 = var2.readUnsignedShort();
         super.field376 = var2.readUnsignedShort();
         this.field548 = var2.readUnsignedByte();
         this.field546 = var2.readUnsignedByte();
         super.field385 = var2.readUnsignedShort();
         super.field378 = var2.readUnsignedShort();
         this.field543 = var2.readUnsignedByte();
         this.field544 = var2.readUnsignedByte();
         super.field380 = Math.min(super.field380, 4);
         super.field377 = new short[1][64][64];
         super.field382 = new short[super.field380][64][64];
         super.field383 = new byte[super.field380][64][64];
         super.field379 = new byte[super.field380][64][64];
         super.field384 = new class31[super.field380][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field459.field458) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            int var6 = var1.readUnsignedByte();
            int var7 = var1.readUnsignedByte();
            if(var4 == super.field385 && var5 == super.field378 && var6 == this.field543 && var7 == this.field544) {
               for(int var8 = 0; var8 < 8; ++var8) {
                  for(int var9 = 0; var9 < 8; ++var9) {
                     this.method217(var8 + this.field543 * 8, var9 + this.field544 * 8, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "1"
   )
   boolean method603(int var1, int var2) {
      return var1 < this.field543 * 8?false:(var2 < this.field544 * 8?false:(var1 >= this.field543 * 8 + 8?false:var2 < this.field544 * 8 + 8));
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1260067267"
   )
   int method601() {
      return this.field548;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1914275121"
   )
   int method606() {
      return this.field546;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1459867512"
   )
   int method607() {
      return this.field543;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-688868975"
   )
   int method608() {
      return this.field544;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class45)) {
         return false;
      } else {
         class45 var2 = (class45)var1;
         return var2.field385 == super.field385 && var2.field378 == super.field378?this.field543 == var2.field543 && var2.field544 == this.field544:false;
      }
   }

   public int hashCode() {
      return super.field385 | super.field378 << 8 | this.field543 << 16 | this.field544 << 24;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILcx;ZS)I",
      garbageValue = "-14632"
   )
   static int method623(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class64.method1017(class82.intStack[--class82.intStackSize]);
      } else {
         var3 = var2?class234.field3210:class82.field1253;
      }

      String var4 = class82.scriptStringStack[--class259.scriptStringStackSize];
      int[] var5 = null;
      if(var4.length() > 0 && var4.charAt(var4.length() - 1) == 'Y') {
         int var6 = class82.intStack[--class82.intStackSize];
         if(var6 > 0) {
            for(var5 = new int[var6]; var6-- > 0; var5[var6] = class82.intStack[--class82.intStackSize]) {
               ;
            }
         }

         var4 = var4.substring(0, var4.length() - 1);
      }

      Object[] var8 = new Object[var4.length() + 1];

      int var7;
      for(var7 = var8.length - 1; var7 >= 1; --var7) {
         if(var4.charAt(var7 - 1) == 's') {
            var8[var7] = class82.scriptStringStack[--class259.scriptStringStackSize];
         } else {
            var8[var7] = new Integer(class82.intStack[--class82.intStackSize]);
         }
      }

      var7 = class82.intStack[--class82.intStackSize];
      if(var7 != -1) {
         var8[0] = new Integer(var7);
      } else {
         var8 = null;
      }

      if(var0 == 1400) {
         var3.field2795 = var8;
      } else if(var0 == 1401) {
         var3.field2798 = var8;
      } else if(var0 == 1402) {
         var3.field2766 = var8;
      } else if(var0 == 1403) {
         var3.mouseEnterListener = var8;
      } else if(var0 == 1404) {
         var3.mouseExitListener = var8;
      } else if(var0 == 1405) {
         var3.field2802 = var8;
      } else if(var0 == 1406) {
         var3.field2805 = var8;
      } else if(var0 == 1407) {
         var3.configListenerArgs = var8;
         var3.configTriggers = var5;
      } else if(var0 == 1408) {
         var3.renderListener = var8;
      } else if(var0 == 1409) {
         var3.field2813 = var8;
      } else if(var0 == 1410) {
         var3.field2801 = var8;
      } else if(var0 == 1411) {
         var3.field2796 = var8;
      } else if(var0 == 1412) {
         var3.mouseHoverListener = var8;
      } else if(var0 == 1414) {
         var3.tableListenerArgs = var8;
         var3.tableModTriggers = var5;
      } else if(var0 == 1415) {
         var3.skillListenerArgs = var8;
         var3.skillTriggers = var5;
      } else if(var0 == 1416) {
         var3.field2735 = var8;
      } else if(var0 == 1417) {
         var3.scrollListener = var8;
      } else if(var0 == 1418) {
         var3.field2815 = var8;
      } else if(var0 == 1419) {
         var3.field2731 = var8;
      } else if(var0 == 1420) {
         var3.field2817 = var8;
      } else if(var0 == 1421) {
         var3.field2804 = var8;
      } else if(var0 == 1422) {
         var3.field2702 = var8;
      } else if(var0 == 1423) {
         var3.field2820 = var8;
      } else if(var0 == 1424) {
         var3.field2821 = var8;
      } else if(var0 == 1425) {
         var3.field2823 = var8;
      } else if(var0 == 1426) {
         var3.field2824 = var8;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var3.field2822 = var8;
      }

      var3.field2793 = true;
      return 1;
   }
}
