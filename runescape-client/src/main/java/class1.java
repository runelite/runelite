import java.awt.Font;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class1 {
   @ObfuscatedName("qc")
   static Font field18;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BIIIIIII[LCollisionData;I)V",
      garbageValue = "1137072140"
   )
   static final void method5(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, CollisionData[] var8) {
      int var9;
      for(int var10 = 0; var10 < 8; ++var10) {
         for(var9 = 0; var9 < 8; ++var9) {
            if(var2 + var10 > 0 && var10 + var2 < 103 && var3 + var9 > 0 && var3 + var9 < 103) {
               var8[var1].flags[var2 + var10][var3 + var9] &= -16777217;
            }
         }
      }

      Buffer var18 = new Buffer(var0);

      for(var9 = 0; var9 < 4; ++var9) {
         for(int var11 = 0; var11 < 64; ++var11) {
            for(int var12 = 0; var12 < 64; ++var12) {
               if(var9 == var4 && var11 >= var5 && var11 < var5 + 8 && var12 >= var6 && var12 < var6 + 8) {
                  int var13 = var2 + class48.method1034(var11 & 7, var12 & 7, var7);
                  int var14 = var11 & 7;
                  int var15 = var12 & 7;
                  int var16 = var7 & 3;
                  int var17;
                  if(var16 == 0) {
                     var17 = var15;
                  } else if(var16 == 1) {
                     var17 = 7 - var14;
                  } else if(var16 == 2) {
                     var17 = 7 - var15;
                  } else {
                     var17 = var14;
                  }

                  GroundObject.method2252(var18, var1, var13, var17 + var3, 0, 0, var7);
               } else {
                  GroundObject.method2252(var18, 0, -1, -1, 0, 0, 0);
               }
            }
         }
      }

   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "1916039858"
   )
   static final void method13(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class16 var9 = null;

      for(class16 var10 = (class16)Client.field427.method3980(); null != var10; var10 = (class16)Client.field427.method3970()) {
         if(var10.field239 == var0 && var10.field238 == var1 && var10.field231 == var2 && var10.field229 == var3) {
            var9 = var10;
            break;
         }
      }

      if(null == var9) {
         var9 = new class16();
         var9.field239 = var0;
         var9.field229 = var3;
         var9.field238 = var1;
         var9.field231 = var2;
         ChatMessages.method253(var9);
         Client.field427.method3963(var9);
      }

      var9.field235 = var4;
      var9.field230 = var5;
      var9.field236 = var6;
      var9.field241 = var7;
      var9.field237 = var8;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)LItemComposition;",
      garbageValue = "-520865922"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.field1186.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ItemComposition.field1187.method3411(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.method1172();
         if(var1.field1178 != -1) {
            var1.method1174(getItemDefinition(var1.field1178), getItemDefinition(var1.note));
         }

         if(var1.field1226 != -1) {
            var1.method1175(getItemDefinition(var1.field1226), getItemDefinition(var1.field1225));
         }

         if(var1.field1213 != -1) {
            var1.method1176(getItemDefinition(var1.field1213), getItemDefinition(var1.field1227));
         }

         if(!ItemComposition.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field1224 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.field1189 = 0;
         }

         ItemComposition.field1186.put(var1, (long)var0);
         return var1;
      }
   }
}
