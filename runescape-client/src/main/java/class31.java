import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
public class class31 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 756524613
   )
   public static int field414;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = 307588911
   )
   static int field411;
   @ObfuscatedName("ja")
   @ObfuscatedSignature(
      signature = "Lcq;"
   )
   @Export("topContextMenuRow")
   static ContextMenuRow topContextMenuRow;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -959773669
   )
   final int field409;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1051428689
   )
   final int field412;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 474940191
   )
   final int field410;

   class31(int var1, int var2, int var3) {
      this.field409 = var1;
      this.field412 = var2;
      this.field410 = var3;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lij;Lij;IZI)Let;",
      garbageValue = "2134885369"
   )
   public static Frames method245(IndexDataBase var0, IndexDataBase var1, int var2, boolean var3) {
      boolean var4 = true;
      int[] var5 = var0.getChilds(var2);

      for(int var6 = 0; var6 < var5.length; ++var6) {
         byte[] var7 = var0.getChild(var2, var5[var6]);
         if(var7 == null) {
            var4 = false;
         } else {
            int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
            byte[] var9;
            if(var3) {
               var9 = var1.getChild(0, var8);
            } else {
               var9 = var1.getChild(var8, 0);
            }

            if(var9 == null) {
               var4 = false;
            }
         }
      }

      if(!var4) {
         return null;
      } else {
         try {
            return new Frames(var0, var1, var2, var3);
         } catch (Exception var11) {
            return null;
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lij;I)V",
      garbageValue = "712287784"
   )
   public static void method246(IndexDataBase var0) {
      class251.field3372 = var0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IILfp;Lfy;B)Z",
      garbageValue = "2"
   )
   static final boolean method244(int var0, int var1, class164 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class163.field2206[var6][var7] = 99;
      class163.field2203[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class163.field2201[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class163.field2202[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var18 != var11) {
         var4 = class163.field2201[var11];
         var5 = class163.field2202[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod3088(2, var4, var5, var3)) {
            class163.field2204 = var4;
            class96.field1423 = var5;
            return true;
         }

         int var15 = class163.field2203[var16][var17] + 1;
         if(var16 > 0 && class163.field2206[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136782) == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0) {
            class163.field2201[var18] = var4 - 1;
            class163.field2202[var18] = var5;
            var18 = var18 + 1 & 4095;
            class163.field2206[var16 - 1][var17] = 2;
            class163.field2203[var16 - 1][var17] = var15;
         }

         if(var16 < 126 && class163.field2206[var16 + 1][var17] == 0 && (var12[var13 + 2][var14] & 19136899) == 0 && (var12[var13 + 2][var14 + 1] & 19136992) == 0) {
            class163.field2201[var18] = var4 + 1;
            class163.field2202[var18] = var5;
            var18 = var18 + 1 & 4095;
            class163.field2206[var16 + 1][var17] = 8;
            class163.field2203[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class163.field2206[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136782) == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0) {
            class163.field2201[var18] = var4;
            class163.field2202[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class163.field2206[var16][var17 - 1] = 1;
            class163.field2203[var16][var17 - 1] = var15;
         }

         if(var17 < 126 && class163.field2206[var16][var17 + 1] == 0 && (var12[var13][var14 + 2] & 19136824) == 0 && (var12[var13 + 1][var14 + 2] & 19136992) == 0) {
            class163.field2201[var18] = var4;
            class163.field2202[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class163.field2206[var16][var17 + 1] = 4;
            class163.field2203[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class163.field2206[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14] & 19136830) == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13][var14 - 1] & 19136911) == 0) {
            class163.field2201[var18] = var4 - 1;
            class163.field2202[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class163.field2206[var16 - 1][var17 - 1] = 3;
            class163.field2203[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 126 && var17 > 0 && class163.field2206[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136911) == 0 && (var12[var13 + 2][var14 - 1] & 19136899) == 0 && (var12[var13 + 2][var14] & 19136995) == 0) {
            class163.field2201[var18] = var4 + 1;
            class163.field2202[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class163.field2206[var16 + 1][var17 - 1] = 9;
            class163.field2203[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 126 && class163.field2206[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136830) == 0 && (var12[var13 - 1][var14 + 2] & 19136824) == 0 && (var12[var13][var14 + 2] & 19137016) == 0) {
            class163.field2201[var18] = var4 - 1;
            class163.field2202[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class163.field2206[var16 - 1][var17 + 1] = 6;
            class163.field2203[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 126 && var17 < 126 && class163.field2206[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 2] & 19137016) == 0 && (var12[var13 + 2][var14 + 2] & 19136992) == 0 && (var12[var13 + 2][var14 + 1] & 19136995) == 0) {
            class163.field2201[var18] = var4 + 1;
            class163.field2202[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class163.field2206[var16 + 1][var17 + 1] = 12;
            class163.field2203[var16 + 1][var17 + 1] = var15;
         }
      }

      class163.field2204 = var4;
      class96.field1423 = var5;
      return false;
   }

   @ObfuscatedName("gs")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-293776407"
   )
   @Export("flush")
   static final void flush(boolean var0) {
      class90.method1683();
      ++Client.field905.field1456;
      if(Client.field905.field1456 >= 50 || var0) {
         Client.field905.field1456 = 0;
         if(!Client.socketError && Client.field905.method1873() != null) {
            PacketNode var1 = class18.method133(ClientPacket.field2354, Client.field905.field1460);
            Client.field905.method1855(var1);

            try {
               Client.field905.method1866();
            } catch (IOException var3) {
               Client.socketError = true;
            }
         }

      }
   }
}
