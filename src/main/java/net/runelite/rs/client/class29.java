package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ae")
public final class class29 extends class84 {
   @ObfuscatedName("k")
   boolean field662 = false;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1142588091
   )
   int field663;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 242430615
   )
   int field664;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1491598193
   )
   int field665;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 42189549
   )
   int field666;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 218139627
   )
   int field667;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -740838951
   )
   int field669 = 0;
   @ObfuscatedName("h")
   class42 field670;
   @ObfuscatedName("qv")
   @ObfuscatedGetter(
      intValue = -999239919
   )
   static int field671;
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = 1636528285
   )
   static int field672;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1131464159
   )
   int field673 = 0;
   @ObfuscatedName("ns")
   static class56 field675;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -660224309
   )
   int field676;
   @ObfuscatedName("p")
   static int[][][] field677;
   @ObfuscatedName("gz")
   static class172 field678;

   @ObfuscatedName("j")
   final void method700(int var1) {
      if(!this.field662) {
         this.field673 += var1;

         while(this.field673 > this.field670.field975[this.field669]) {
            this.field673 -= this.field670.field975[this.field669];
            ++this.field669;
            if(this.field669 >= this.field670.field973.length) {
               this.field662 = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("f")
   protected final class104 vmethod1921() {
      class43 var1 = class10.method156(this.field667);
      class104 var2;
      if(!this.field662) {
         var2 = var1.method948(this.field669);
      } else {
         var2 = var1.method948(-1);
      }

      return null == var2?null:var2;
   }

   class29(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field667 = var1;
      this.field664 = var2;
      this.field665 = var3;
      this.field666 = var4;
      this.field676 = var5;
      this.field663 = var6 + var7;
      int var8 = class10.method156(this.field667).field1005;
      if(var8 != -1) {
         this.field662 = false;
         this.field670 = client.method584(var8);
      } else {
         this.field662 = true;
      }

   }

   @ObfuscatedName("j")
   public static final void method711(long var0) {
      if(var0 > 0L) {
         if(0L == var0 % 10L) {
            long var2 = var0 - 1L;

            try {
               Thread.sleep(var2);
            } catch (InterruptedException var7) {
               ;
            }

            try {
               Thread.sleep(1L);
            } catch (InterruptedException var6) {
               ;
            }
         } else {
            try {
               Thread.sleep(var0);
            } catch (InterruptedException var5) {
               ;
            }
         }

      }
   }
}
