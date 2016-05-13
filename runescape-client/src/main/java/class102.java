import java.awt.Container;
import java.awt.Insets;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
@Implements("FrameMap")
public class class102 extends class208 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 774987985
   )
   int field1769;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1234449633
   )
   int field1770;
   @ObfuscatedName("x")
   int[][] field1771;
   @ObfuscatedName("p")
   int[] field1773;
   @ObfuscatedName("o")
   static byte[][][] field1774;
   @ObfuscatedName("bj")
   static class168 field1776;

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1979708164"
   )
   static void method2268() {
      client var0 = client.field276;
      client var1 = client.field276;
      synchronized(client.field276) {
         Container var2 = client.field276.method2996();
         if(null != var2) {
            class32.field770 = Math.max(var2.getSize().width, class98.field1682);
            class131.field2079 = Math.max(var2.getSize().height, class136.field2114);
            if(class85.field1464 == var2) {
               Insets var3 = class85.field1464.getInsets();
               class32.field770 -= var3.left + var3.right;
               class131.field2079 -= var3.bottom + var3.top;
            }

            if(class32.field770 <= 0) {
               class32.field770 = 1;
            }

            if(class131.field2079 <= 0) {
               class131.field2079 = 1;
            }

            int var7 = client.field336?2:1;
            if(var7 == 1) {
               class15.field214 = client.field492;
               class15.field215 = client.field341;
            } else {
               class15.field214 = Math.min(class32.field770, 7680);
               class15.field215 = Math.min(class131.field2079, 2160);
            }

            class144.field2210 = (class32.field770 - class15.field214) / 2;
            class144.field2211 = 0;
            class122.field2024.setSize(class15.field214, class15.field215);
            class135.field2094 = class109.method2415(class15.field214, class15.field215, class122.field2024);
            if(class85.field1464 == var2) {
               Insets var4 = class85.field1464.getInsets();
               class122.field2024.setLocation(class144.field2210 + var4.left, class144.field2211 + var4.top);
            } else {
               class122.field2024.setLocation(class144.field2210, class144.field2211);
            }

            class4.method40();
            if(-1 != client.field412) {
               class9.method125(true);
            }

            class0.method0();
         }

      }
   }

   class102(int var1, byte[] var2) {
      this.field1770 = var1;
      class119 var3 = new class119(var2);
      this.field1769 = var3.method2492();
      this.field1773 = new int[this.field1769];
      this.field1771 = new int[this.field1769][];

      int var4;
      for(var4 = 0; var4 < this.field1769; ++var4) {
         this.field1773[var4] = var3.method2492();
      }

      for(var4 = 0; var4 < this.field1769; ++var4) {
         this.field1771[var4] = new int[var3.method2492()];
      }

      for(var4 = 0; var4 < this.field1769; ++var4) {
         for(int var5 = 0; var5 < this.field1771[var4].length; ++var5) {
            this.field1771[var4][var5] = var3.method2492();
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(CIB)I",
      garbageValue = "-36"
   )
   static int method2269(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "936238385"
   )
   static final void method2270(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class107.method2369(var0, var1, class21.field581) - var2;
         var0 -= class77.field1404;
         var3 -= class7.field138;
         var1 -= class72.field1353;
         int var4 = class91.field1596[class59.field1222];
         int var5 = class91.field1597[class59.field1222];
         int var6 = class91.field1596[class32.field750];
         int var7 = class91.field1597[class32.field750];
         int var8 = var1 * var6 + var7 * var0 >> 16;
         var1 = var1 * var7 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var5 * var3 - var1 * var4 >> 16;
         var1 = var4 * var3 + var5 * var1 >> 16;
         if(var1 >= 50) {
            client.field385 = var0 * client.field555 / var1 + client.field472 / 2;
            client.field386 = client.field555 * var8 / var1 + client.field383 / 2;
         } else {
            client.field385 = -1;
            client.field386 = -1;
         }
      } else {
         client.field385 = -1;
         client.field386 = -1;
      }

   }
}
