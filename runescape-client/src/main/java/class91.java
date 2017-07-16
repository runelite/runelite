import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
public enum class91 implements RSEnum {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lcd;"
   )
   field1410(0),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lcd;"
   )
   field1416(1),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lcd;"
   )
   field1413(2),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lcd;"
   )
   field1409(3);

   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1580104769
   )
   final int field1412;
   @ObfuscatedName("p")
   public static short[][] field1414;

   class91(int var3) {
      this.field1412 = var3;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1952293135"
   )
   public int rsOrdinal() {
      return this.field1412;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)Let;",
      garbageValue = "-57"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.skeletons.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         IndexDataBase var3 = Sequence.skel_ref;
         IndexDataBase var4 = class46.skin_ref;
         boolean var5 = true;
         int[] var6 = var3.getChilds(var0);

         for(int var7 = 0; var7 < var6.length; ++var7) {
            byte[] var8 = var3.getChild(var0, var6[var7]);
            if(var8 == null) {
               var5 = false;
            } else {
               int var9 = (var8[0] & 255) << 8 | var8[1] & 255;
               byte[] var10 = var4.getChild(var9, 0);
               if(var10 == null) {
                  var5 = false;
               }
            }
         }

         Frames var2;
         if(!var5) {
            var2 = null;
         } else {
            try {
               var2 = new Frames(var3, var4, var0, false);
            } catch (Exception var12) {
               var2 = null;
            }
         }

         if(var2 != null) {
            Sequence.skeletons.put(var2, (long)var0);
         }

         return var2;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-779018806"
   )
   static final boolean method1698(int var0, int var1) {
      ObjectComposition var2 = PlayerComposition.getObjectDefinition(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method4484(var1);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-796456852"
   )
   public static String method1700(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 97 || var4 > 122) && (var4 < 65 || var4 > 90) && (var4 < 48 || var4 > 57) && var4 != 46 && var4 != 45 && var4 != 42 && var4 != 95) {
            if(var4 == 32) {
               var2.append('+');
            } else {
               byte var5 = class157.method2970(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }

   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "(Lhy;III)V",
      garbageValue = "-1292109678"
   )
   static final void method1699(Widget var0, int var1, int var2) {
      if(Client.field1079 == null && !Client.isMenuOpen) {
         if(var0 != null && class89.method1688(var0) != null) {
            Client.field1079 = var0;
            Client.field920 = class89.method1688(var0);
            Client.field1081 = var1;
            Client.field1082 = var2;
            class33.field454 = 0;
            Client.field1174 = false;
            int var3 = class134.method2587();
            if(var3 != -1) {
               class98.field1525 = new class89();
               class98.field1525.field1402 = Client.menuActionParams0[var3];
               class98.field1525.field1399 = Client.menuActionParams1[var3];
               class98.field1525.field1400 = Client.menuTypes[var3];
               class98.field1525.field1403 = Client.menuIdentifiers[var3];
               class98.field1525.field1401 = Client.menuOptions[var3];
            }

         }
      }
   }
}
