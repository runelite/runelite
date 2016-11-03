import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
final class class22 implements Comparator {
   // $FF: synthetic field
   final boolean val$preferOwnWorld;
   @ObfuscatedName("q")
   static class170 field584;
   @ObfuscatedName("s")
   static String[] field587;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;I)I",
      garbageValue = "1687267001"
   )
   int method580(class217 var1, class217 var2) {
      if(var1.field3197 == var2.field3197) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(Client.world == var1.field3197) {
               return -1;
            }

            if(var2.field3197 == Client.world) {
               return 1;
            }
         }

         return var1.field3197 < var2.field3197?-1:1;
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method580((class217)var1, (class217)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   class22(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)I",
      garbageValue = "141149483"
   )
   public static int method584(CharSequence var0, int var1, boolean var2) {
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
                  throw new NumberFormatException();
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var1 * var5 + var10;
            if(var5 != var9 / var1) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IS)LItemComposition;",
      garbageValue = "-5838"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.field1172.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ItemComposition.field1169.method3305(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.method1113();
         if(var1.field1177 != -1) {
            var1.method1159(getItemDefinition(var1.field1177), getItemDefinition(var1.note));
         }

         if(var1.field1218 != -1) {
            var1.method1117(getItemDefinition(var1.field1218), getItemDefinition(var1.field1203));
         }

         if(var1.field1196 != -1) {
            var1.method1118(getItemDefinition(var1.field1196), getItemDefinition(var1.field1216));
         }

         if(!ItemComposition.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field1170 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.field1214 = 0;
         }

         ItemComposition.field1172.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IZZZI)Lclass171;",
      garbageValue = "-2084648397"
   )
   static class171 method586(int var0, boolean var1, boolean var2, boolean var3) {
      class137 var4 = null;
      if(class152.field2279 != null) {
         var4 = new class137(var0, class152.field2279, XItemContainer.field218[var0], 1000000);
      }

      return new class171(var4, class31.field709, var0, var1, var2, var3);
   }
}
