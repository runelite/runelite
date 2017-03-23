import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public class class1 {
   @ObfuscatedName("j")
   public static Comparator field11 = new class7();
   @ObfuscatedName("be")
   static class184 field12;
   @ObfuscatedName("w")
   public static Comparator field13;
   @ObfuscatedName("d")
   public static Comparator field14;
   @ObfuscatedName("cc")
   static RSSocket field15;
   @ObfuscatedName("in")
   static Widget field16;
   @ObfuscatedName("c")
   public static Comparator field19;
   @ObfuscatedName("x")
   public final List field21;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "862629919"
   )
   public void method16(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field21, var1);
      } else {
         Collections.sort(this.field21, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "-8597"
   )
   static int method18(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method2405((long)var0);
      if(null == var2) {
         return 0;
      } else if(var1 == -1) {
         return 0;
      } else {
         int var3 = 0;

         for(int var4 = 0; var4 < var2.stackSizes.length; ++var4) {
            if(var1 == var2.itemIds[var4]) {
               var3 += var2.stackSizes[var4];
            }
         }

         return var3;
      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "8"
   )
   static final void method20() {
      int[] var0 = class45.field925;

      int var1;
      for(var1 = 0; var1 < class45.field934; ++var1) {
         Player var2 = Client.cachedPlayers[var0[var1]];
         if(var2 != null && var2.field641 > 0) {
            --var2.field641;
            if(var2.field641 == 0) {
               var2.overhead = null;
            }
         }
      }

      for(var1 = 0; var1 < Client.field351; ++var1) {
         int var4 = Client.field570[var1];
         NPC var3 = Client.cachedNPCs[var4];
         if(null != var3 && var3.field641 > 0) {
            --var3.field641;
            if(var3.field641 == 0) {
               var3.overhead = null;
            }
         }
      }

   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "1"
   )
   public class1(Buffer var1, boolean var2) {
      int var3 = var1.readUnsignedShort();
      boolean var4 = var1.readUnsignedByte() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.readUnsignedShort();
      this.field21 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field21.add(new class2(var1, var5, var3));
      }

   }

   static {
      new class0();
      field19 = new class5();
      field14 = new class6();
      field13 = new class3();
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "135927553"
   )
   static final int method21(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class10.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = var6 * class10.tileHeights[var5][1 + var3][var4] + (128 - var6) * class10.tileHeights[var5][var3][var4] >> 7;
         int var9 = class10.tileHeights[var5][var3][1 + var4] * (128 - var6) + var6 * class10.tileHeights[var5][1 + var3][1 + var4] >> 7;
         return (128 - var7) * var8 + var7 * var9 >> 7;
      } else {
         return 0;
      }
   }
}
