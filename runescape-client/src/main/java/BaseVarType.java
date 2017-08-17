import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
@Implements("BaseVarType")
public enum BaseVarType implements RSEnum {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lx;"
   )
   @Export("INTEGER")
   INTEGER(0, 0, Integer.class, new class2()),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lx;"
   )
   @Export("LONG")
   LONG(1, 1, Long.class, new class3()),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lx;"
   )
   @Export("STRING")
   STRING(2, 2, String.class, new class5());

   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 743117857
   )
   final int field25;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 205167819
   )
   final int field26;
   @ObfuscatedName("t")
   static int[] field28;
   @ObfuscatedName("gd")
   @ObfuscatedSignature(
      signature = "[Ljr;"
   )
   static IndexedSprite[] field29;
   @ObfuscatedName("c")
   @Export("validInterfaces")
   public static boolean[] validInterfaces;

   @ObfuscatedSignature(
      signature = "(IILjava/lang/Class;Lj;)V"
   )
   BaseVarType(int var3, int var4, Class var5, class0 var6) {
      this.field25 = var3;
      this.field26 = var4;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "316484705"
   )
   public int rsOrdinal() {
      return this.field26;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1127283123"
   )
   public static int method12(int var0) {
      Varbit var2 = (Varbit)Varbit.varbits.get((long)var0);
      Varbit var1;
      if(var2 != null) {
         var1 = var2;
      } else {
         byte[] var7 = Varbit.varbit_ref.getConfigData(14, var0);
         var2 = new Varbit();
         if(var7 != null) {
            var2.decode(new Buffer(var7));
         }

         Varbit.varbits.put(var2, (long)var0);
         var1 = var2;
      }

      int var3 = var1.configId;
      int var4 = var1.leastSignificantBit;
      int var5 = var1.mostSignificantBit;
      int var6 = class212.field2602[var5 - var4];
      return class212.widgetSettings[var3] >> var4 & var6;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)Z",
      garbageValue = "1202848118"
   )
   static boolean method13(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  return false;
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               return false;
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var5 * var1 + var10;
            if(var9 / var1 != var5) {
               return false;
            }

            var5 = var9;
            var4 = true;
         }

         return var4;
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "(Lhi;I)V",
      garbageValue = "-1874842569"
   )
   static final void method11(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 324) {
         if(Client.field1198 == -1) {
            Client.field1198 = var0.spriteId;
            Client.field1100 = var0.field2685 * -1;
         }

         if(Client.field1008.isFemale) {
            var0.spriteId = Client.field1198;
         } else {
            var0.spriteId = Client.field1100 * -1;
         }

      } else if(var1 == 325) {
         if(Client.field1198 == -1) {
            Client.field1198 = var0.spriteId;
            Client.field1100 = var0.field2685 * -1;
         }

         if(Client.field1008.isFemale) {
            var0.spriteId = Client.field1100 * -1;
         } else {
            var0.spriteId = Client.field1198;
         }

      } else if(var1 == 327) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 0;
      } else if(var1 == 328) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 1;
      }
   }
}
