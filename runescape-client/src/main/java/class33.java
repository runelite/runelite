import java.awt.Component;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public final class class33 extends Renderable {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -919243501
   )
   int field734;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 56447747
   )
   int field735;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -943010809
   )
   int field736;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 769000149
   )
   int field737;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1240422361
   )
   int field739;
   @ObfuscatedName("v")
   boolean field740 = false;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -943936889
   )
   int field741 = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -212983011
   )
   int field742;
   @ObfuscatedName("u")
   Sequence field743;
   @ObfuscatedName("au")
   static ModIcon[] field744;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 289493473
   )
   int field745 = 0;
   @ObfuscatedName("ap")
   @Export("indexSoundEffects")
   static IndexData indexSoundEffects;

   class33(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field739 = var1;
      this.field735 = var2;
      this.field736 = var3;
      this.field742 = var4;
      this.field737 = var5;
      this.field734 = var6 + var7;
      int var8 = class190.method3462(this.field739).field2811;
      if(var8 != -1) {
         this.field740 = false;
         this.field743 = NPCComposition.getAnimation(var8);
      } else {
         this.field740 = true;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "-18"
   )
   protected final Model getModel() {
      Spotanim var1 = class190.method3462(this.field739);
      Model var2;
      if(!this.field740) {
         var2 = var1.method3478(this.field745);
      } else {
         var2 = var1.method3478(-1);
      }

      return var2 == null?null:var2;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "105"
   )
   static final void method715(int var0, int var1, int var2) {
      int var3;
      for(var3 = 0; var3 < 8; ++var3) {
         for(int var4 = 0; var4 < 8; ++var4) {
            class10.tileHeights[var0][var1 + var3][var4 + var2] = 0;
         }
      }

      if(var1 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class10.tileHeights[var0][var1][var2 + var3] = class10.tileHeights[var0][var1 - 1][var3 + var2];
         }
      }

      if(var2 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class10.tileHeights[var0][var1 + var3][var2] = class10.tileHeights[var0][var1 + var3][var2 - 1];
         }
      }

      if(var1 > 0 && class10.tileHeights[var0][var1 - 1][var2] != 0) {
         class10.tileHeights[var0][var1][var2] = class10.tileHeights[var0][var1 - 1][var2];
      } else if(var2 > 0 && class10.tileHeights[var0][var1][var2 - 1] != 0) {
         class10.tileHeights[var0][var1][var2] = class10.tileHeights[var0][var1][var2 - 1];
      } else if(var1 > 0 && var2 > 0 && class10.tileHeights[var0][var1 - 1][var2 - 1] != 0) {
         class10.tileHeights[var0][var1][var2] = class10.tileHeights[var0][var1 - 1][var2 - 1];
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass103;Ljava/awt/Component;IIB)Lclass57;",
      garbageValue = "0"
   )
   public static final class57 method717(class103 var0, Component var1, int var2, int var3) {
      if(class57.field1032 == 0) {
         throw new IllegalStateException();
      } else if(var2 >= 0 && var2 < 2) {
         if(var3 < 256) {
            var3 = 256;
         }

         try {
            class60 var4 = new class60();
            var4.field1031 = new int[(class57.field1047?2:1) * 256];
            var4.field1036 = var3;
            var4.vmethod1143(var1);
            var4.field1035 = (var3 & -1024) + 1024;
            if(var4.field1035 > 16384) {
               var4.field1035 = 16384;
            }

            var4.vmethod1144(var4.field1035);
            if(class196.field2862 > 0 && class57.field1030 == null) {
               class57.field1030 = new class59();
               class219.field3197 = Executors.newScheduledThreadPool(1);
               class219.field3197.scheduleAtFixedRate(class57.field1030, 0L, 10L, TimeUnit.MILLISECONDS);
            }

            if(class57.field1030 != null) {
               if(class57.field1030.field1061[var2] != null) {
                  throw new IllegalArgumentException();
               }

               class57.field1030.field1061[var2] = var4;
            }

            return var4;
         } catch (Throwable var5) {
            return new class57();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1143183763"
   )
   final void method720(int var1) {
      if(!this.field740) {
         this.field741 += var1;

         while(this.field741 > this.field743.frameLenghts[this.field745]) {
            this.field741 -= this.field743.frameLenghts[this.field745];
            ++this.field745;
            if(this.field745 >= this.field743.frameIDs.length) {
               this.field740 = true;
               break;
            }
         }

      }
   }
}
