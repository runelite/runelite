import java.awt.datatransfer.Clipboard;
import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
public class class99 extends class109 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1289764147
   )
   int field1644;
   @ObfuscatedName("x")
   long[] field1645 = new long[10];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 868255537
   )
   int field1646 = 1;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = -5872150964788914705L
   )
   long field1647 = WallObject.method1985();
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -418741851
   )
   int field1649 = 0;
   @ObfuscatedName("px")
   static GarbageCollectorMXBean field1652;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1712139091
   )
   int field1653 = 256;
   @ObfuscatedName("ps")
   static Clipboard field1655;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "558296171"
   )
   void vmethod2132() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1645[var1] = 0L;
      }

   }

   class99() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1645[var1] = this.field1647;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1258551841"
   )
   int vmethod2133(int var1, int var2) {
      int var3 = this.field1653;
      int var4 = this.field1646;
      this.field1653 = 300;
      this.field1646 = 1;
      this.field1647 = WallObject.method1985();
      if(0L == this.field1645[this.field1644]) {
         this.field1653 = var3;
         this.field1646 = var4;
      } else if(this.field1647 > this.field1645[this.field1644]) {
         this.field1653 = (int)((long)(var1 * 2560) / (this.field1647 - this.field1645[this.field1644]));
      }

      if(this.field1653 < 25) {
         this.field1653 = 25;
      }

      if(this.field1653 > 256) {
         this.field1653 = 256;
         this.field1646 = (int)((long)var1 - (this.field1647 - this.field1645[this.field1644]) / 10L);
      }

      if(this.field1646 > var1) {
         this.field1646 = var1;
      }

      this.field1645[this.field1644] = this.field1647;
      this.field1644 = (this.field1644 + 1) % 10;
      int var5;
      if(this.field1646 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(this.field1645[var5] != 0L) {
               this.field1645[var5] += (long)this.field1646;
            }
         }
      }

      if(this.field1646 < var2) {
         this.field1646 = var2;
      }

      class47.method970((long)this.field1646);

      for(var5 = 0; this.field1649 < 256; this.field1649 += this.field1653) {
         ++var5;
      }

      this.field1649 &= 255;
      return var5;
   }

   @ObfuscatedName("x")
   public static String method2037(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class205.field3095[(int)(var6 - var0 * 37L)];
               if(var8 == 95) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "528136632"
   )
   static final void method2038(Widget var0, int var1, int var2) {
      if(null == Client.field462 && !Client.isMenuOpen) {
         if(null != var0 && class57.method1164(var0) != null) {
            Client.field462 = var0;
            Client.field463 = class57.method1164(var0);
            Client.field464 = var1;
            Client.field466 = var2;
            class40.field815 = 0;
            Client.field473 = false;
            int var3 = class2.method23();
            if(var3 != -1) {
               class49.method979(var3);
            }

         }
      }
   }
}
