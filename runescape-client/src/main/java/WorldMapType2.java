import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
@Implements("WorldMapType2")
public class WorldMapType2 implements WorldMapSectionBase {
   @ObfuscatedName("oy")
   @ObfuscatedGetter(
      intValue = -858288283
   )
   static int field491;
   @ObfuscatedName("l")
   public static String[] field490;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1105510219
   )
   int field483;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1542678959
   )
   int field489;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1771120471
   )
   int field485;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1774723351
   )
   int field486;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1204838243
   )
   int field484;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -587599695
   )
   int field488;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lae;I)V",
      garbageValue = "-1518418003"
   )
   public void vmethod701(WorldMapData var1) {
      if(var1.field426 > this.field484) {
         var1.field426 = this.field484;
      }

      if(var1.field433 < this.field484) {
         var1.field433 = this.field484;
      }

      if(var1.field428 > this.field488) {
         var1.field428 = this.field488;
      }

      if(var1.field422 < this.field488) {
         var1.field422 = this.field488;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-2038931748"
   )
   public boolean vmethod702(int var1, int var2, int var3) {
      return var1 >= this.field483 && var1 < this.field483 + this.field489?var2 >> 6 == this.field485 && var3 >> 6 == this.field486:false;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1297520065"
   )
   public boolean vmethod703(int var1, int var2) {
      return var1 >> 6 == this.field484 && var2 >> 6 == this.field488;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-336358408"
   )
   public int[] vmethod711(int var1, int var2, int var3) {
      if(!this.vmethod702(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field484 * 64 - this.field485 * 64 + var2, var3 + (this.field488 * 64 - this.field486 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)Lhn;",
      garbageValue = "1673050917"
   )
   public Coordinates vmethod700(int var1, int var2) {
      if(!this.vmethod703(var1, var2)) {
         return null;
      } else {
         int var3 = this.field485 * 64 - this.field484 * 64 + var1;
         int var4 = this.field486 * 64 - this.field488 * 64 + var2;
         return new Coordinates(this.field483, var3, var4);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgj;B)V",
      garbageValue = "7"
   )
   public void vmethod706(Buffer var1) {
      this.field483 = var1.readUnsignedByte();
      this.field489 = var1.readUnsignedByte();
      this.field485 = var1.readUnsignedShort();
      this.field486 = var1.readUnsignedShort();
      this.field484 = var1.readUnsignedShort();
      this.field488 = var1.readUnsignedShort();
      this.method517();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-122"
   )
   void method517() {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Len;II)V",
      garbageValue = "808194559"
   )
   public static final void method532(Model var0, int var1) {
      for(int var2 = 0; var2 < var0.indicesCount; ++var2) {
         if(var0.field1813[var2] != -2) {
            int var3 = var0.indices1[var2];
            int var4 = var0.indices2[var2];
            int var5 = var0.indices3[var2];
            int var6 = Model.modelViewportYs[var3];
            int var7 = Model.modelViewportYs[var4];
            int var8 = Model.modelViewportYs[var5];
            class25.method189(Model.modelViewportXs[var3], Model.modelViewportXs[var4], Model.modelViewportXs[var5], var6, var7, var8, var1);
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1686168130"
   )
   public static boolean method534(int var0) {
      return (var0 & 1) != 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IS)I",
      garbageValue = "3735"
   )
   public static int method516(CharSequence var0, CharSequence var1, int var2) {
      int var3 = var0.length();
      int var4 = var1.length();
      int var5 = 0;
      int var6 = 0;
      char var7 = 0;
      char var8 = 0;

      while(var5 - var7 < var3 || var6 - var8 < var4) {
         if(var5 - var7 >= var3) {
            return -1;
         }

         if(var6 - var8 >= var4) {
            return 1;
         }

         char var9;
         if(var7 != 0) {
            var9 = var7;
            boolean var14 = false;
         } else {
            var9 = var0.charAt(var5++);
         }

         char var10;
         if(var8 != 0) {
            var10 = var8;
            boolean var15 = false;
         } else {
            var10 = var1.charAt(var6++);
         }

         var7 = NPC.method1833(var9);
         var8 = NPC.method1833(var10);
         var9 = class85.method1846(var9, var2);
         var10 = class85.method1846(var10, var2);
         if(var10 != var9 && Character.toUpperCase(var9) != Character.toUpperCase(var10)) {
            var9 = Character.toLowerCase(var9);
            var10 = Character.toLowerCase(var10);
            if(var9 != var10) {
               return class1.method1(var9, var2) - class1.method1(var10, var2);
            }
         }
      }

      int var16 = Math.min(var3, var4);

      char var12;
      int var17;
      for(var17 = 0; var17 < var16; ++var17) {
         char var11 = var0.charAt(var17);
         var12 = var1.charAt(var17);
         if(var11 != var12 && Character.toUpperCase(var11) != Character.toUpperCase(var12)) {
            var11 = Character.toLowerCase(var11);
            var12 = Character.toLowerCase(var12);
            if(var11 != var12) {
               return class1.method1(var11, var2) - class1.method1(var12, var2);
            }
         }
      }

      var17 = var3 - var4;
      if(var17 != 0) {
         return var17;
      } else {
         for(int var18 = 0; var18 < var16; ++var18) {
            var12 = var0.charAt(var18);
            char var13 = var1.charAt(var18);
            if(var13 != var12) {
               return class1.method1(var12, var2) - class1.method1(var13, var2);
            }
         }

         return 0;
      }
   }
}
