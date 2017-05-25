import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("h")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 985852265
   )
   @Export("world")
   int world;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1785513907
   )
   @Export("rank")
   int rank;
   @ObfuscatedName("i")
   @Export("name")
   String name;
   @ObfuscatedName("v")
   boolean field796;
   @ObfuscatedName("g")
   boolean field797;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-15836678"
   )
   static int method1095(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 4200) {
         var3 = class83.intStack[--class83.intStackSize];
         class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = class51.getItemDefinition(var3).name;
         return 1;
      } else {
         int var13;
         ItemComposition var17;
         if(var0 == 4201) {
            class83.intStackSize -= 2;
            var3 = class83.intStack[class83.intStackSize];
            var13 = class83.intStack[class83.intStackSize + 1];
            var17 = class51.getItemDefinition(var3);
            if(var13 >= 1 && var13 <= 5 && var17.groundActions[var13 - 1] != null) {
               class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var17.groundActions[var13 - 1];
            } else {
               class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 4202) {
            class83.intStackSize -= 2;
            var3 = class83.intStack[class83.intStackSize];
            var13 = class83.intStack[class83.intStackSize + 1];
            var17 = class51.getItemDefinition(var3);
            if(var13 >= 1 && var13 <= 5 && var17.inventoryActions[var13 - 1] != null) {
               class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var17.inventoryActions[var13 - 1];
            } else {
               class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 4203) {
            var3 = class83.intStack[--class83.intStackSize];
            class83.intStack[++class83.intStackSize - 1] = class51.getItemDefinition(var3).price;
            return 1;
         } else if(var0 == 4204) {
            var3 = class83.intStack[--class83.intStackSize];
            class83.intStack[++class83.intStackSize - 1] = class51.getItemDefinition(var3).isStackable == 1?1:0;
            return 1;
         } else {
            ItemComposition var4;
            if(var0 == 4205) {
               var3 = class83.intStack[--class83.intStackSize];
               var4 = class51.getItemDefinition(var3);
               if(var4.notedTemplate == -1 && var4.note >= 0) {
                  class83.intStack[++class83.intStackSize - 1] = var4.note;
               } else {
                  class83.intStack[++class83.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4206) {
               var3 = class83.intStack[--class83.intStackSize];
               var4 = class51.getItemDefinition(var3);
               if(var4.notedTemplate >= 0 && var4.note >= 0) {
                  class83.intStack[++class83.intStackSize - 1] = var4.note;
               } else {
                  class83.intStack[++class83.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4207) {
               var3 = class83.intStack[--class83.intStackSize];
               class83.intStack[++class83.intStackSize - 1] = class51.getItemDefinition(var3).isMembers?1:0;
               return 1;
            } else if(var0 == 4208) {
               var3 = class83.intStack[--class83.intStackSize];
               var4 = class51.getItemDefinition(var3);
               if(var4.field3535 == -1 && var4.field3534 >= 0) {
                  class83.intStack[++class83.intStackSize - 1] = var4.field3534;
               } else {
                  class83.intStack[++class83.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4209) {
               var3 = class83.intStack[--class83.intStackSize];
               var4 = class51.getItemDefinition(var3);
               if(var4.field3535 >= 0 && var4.field3534 >= 0) {
                  class83.intStack[++class83.intStackSize - 1] = var4.field3534;
               } else {
                  class83.intStack[++class83.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4210) {
               String var15 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
               var13 = class83.intStack[--class83.intStackSize];
               boolean var6 = var13 == 1;
               String var5 = var15.toLowerCase();
               short[] var7 = new short[16];
               int var8 = 0;
               int var9 = 0;

               while(true) {
                  if(var9 >= ItemComposition.field3484) {
                     class170.field2327 = var7;
                     XGrandExchangeOffer.field304 = 0;
                     class44.field573 = var8;
                     String[] var16 = new String[class44.field573];

                     for(int var10 = 0; var10 < class44.field573; ++var10) {
                        var16[var10] = class51.getItemDefinition(var7[var10]).name;
                     }

                     short[] var18 = class170.field2327;
                     class116.method2148(var16, var18, 0, var16.length - 1);
                     break;
                  }

                  ItemComposition var14 = class51.getItemDefinition(var9);
                  if((!var6 || var14.field3531) && var14.notedTemplate == -1 && var14.name.toLowerCase().indexOf(var5) != -1) {
                     if(var8 >= 250) {
                        class44.field573 = -1;
                        class170.field2327 = null;
                        break;
                     }

                     if(var8 >= var7.length) {
                        short[] var11 = new short[var7.length * 2];

                        for(int var12 = 0; var12 < var8; ++var12) {
                           var11[var12] = var7[var12];
                        }

                        var7 = var11;
                     }

                     var7[var8++] = (short)var9;
                  }

                  ++var9;
               }

               class83.intStack[++class83.intStackSize - 1] = class44.field573;
               return 1;
            } else if(var0 != 4211) {
               if(var0 == 4212) {
                  XGrandExchangeOffer.field304 = 0;
                  return 1;
               } else {
                  return 2;
               }
            } else {
               if(class170.field2327 != null && XGrandExchangeOffer.field304 < class44.field573) {
                  class83.intStack[++class83.intStackSize - 1] = class170.field2327[++XGrandExchangeOffer.field304 - 1] & '\uffff';
               } else {
                  class83.intStack[++class83.intStackSize - 1] = -1;
               }

               return 1;
            }
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BIS)I",
      garbageValue = "6638"
   )
   public static int method1096(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var1 + var6);
         if((var7 <= 0 || var7 >= 128) && (var7 < 160 || var7 > 255)) {
            if(var7 == 8364) {
               var3[var4 + var6] = -128;
            } else if(var7 == 8218) {
               var3[var6 + var4] = -126;
            } else if(var7 == 402) {
               var3[var4 + var6] = -125;
            } else if(var7 == 8222) {
               var3[var4 + var6] = -124;
            } else if(var7 == 8230) {
               var3[var6 + var4] = -123;
            } else if(var7 == 8224) {
               var3[var4 + var6] = -122;
            } else if(var7 == 8225) {
               var3[var4 + var6] = -121;
            } else if(var7 == 710) {
               var3[var4 + var6] = -120;
            } else if(var7 == 8240) {
               var3[var4 + var6] = -119;
            } else if(var7 == 352) {
               var3[var6 + var4] = -118;
            } else if(var7 == 8249) {
               var3[var4 + var6] = -117;
            } else if(var7 == 338) {
               var3[var4 + var6] = -116;
            } else if(var7 == 381) {
               var3[var4 + var6] = -114;
            } else if(var7 == 8216) {
               var3[var4 + var6] = -111;
            } else if(var7 == 8217) {
               var3[var4 + var6] = -110;
            } else if(var7 == 8220) {
               var3[var6 + var4] = -109;
            } else if(var7 == 8221) {
               var3[var6 + var4] = -108;
            } else if(var7 == 8226) {
               var3[var4 + var6] = -107;
            } else if(var7 == 8211) {
               var3[var4 + var6] = -106;
            } else if(var7 == 8212) {
               var3[var4 + var6] = -105;
            } else if(var7 == 732) {
               var3[var6 + var4] = -104;
            } else if(var7 == 8482) {
               var3[var6 + var4] = -103;
            } else if(var7 == 353) {
               var3[var4 + var6] = -102;
            } else if(var7 == 8250) {
               var3[var6 + var4] = -101;
            } else if(var7 == 339) {
               var3[var4 + var6] = -100;
            } else if(var7 == 382) {
               var3[var6 + var4] = -98;
            } else if(var7 == 376) {
               var3[var4 + var6] = -97;
            } else {
               var3[var4 + var6] = 63;
            }
         } else {
            var3[var6 + var4] = (byte)var7;
         }
      }

      return var5;
   }

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   static final void method1097() {
      Client.secretPacketBuffer1.putOpcode(123);

      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3606(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3607()) {
         if(var0.field810 == 0 || var0.field810 == 3) {
            class276.method4969(var0, true);
         }
      }

      if(Client.field1054 != null) {
         class219.method4130(Client.field1054);
         Client.field1054 = null;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-111598595"
   )
   public static int method1098(CharSequence var0) {
      return class217.method4119(var0, 10, true);
   }
}
