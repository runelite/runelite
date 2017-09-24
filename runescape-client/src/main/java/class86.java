import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
public class class86 {
   @ObfuscatedName("o")
   static final BigInteger field1387;
   @ObfuscatedName("n")
   static final BigInteger field1383;
   @ObfuscatedName("pl")
   @ObfuscatedGetter(
      intValue = 1076953163
   )
   static int field1392;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -307335085
   )
   static int field1391;

   static {
      field1387 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
      field1383 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   }

   @ObfuscatedName("je")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)Ljava/lang/String;",
      garbageValue = "2"
   )
   static String method1709(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.socketType == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.socketType == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.socketType == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.socketType == 5) {
         var0 = var0 + "-wti";
      } else if(Client.socketType == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(class25.sessionToken != null) {
         var3 = "/p=" + class25.sessionToken;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.languageId + "/a=" + MouseInput.field756 + var3 + "/";
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILck;ZI)I",
      garbageValue = "2106914071"
   )
   static int method1705(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 100) {
         Ignore.intStackSize -= 3;
         var3 = class82.intStack[Ignore.intStackSize];
         var4 = class82.intStack[Ignore.intStackSize + 1];
         int var5 = class82.intStack[Ignore.intStackSize + 2];
         if(var4 == 0) {
            throw new RuntimeException();
         } else {
            Widget var6 = GZipDecompressor.method3177(var3);
            if(var6.children == null) {
               var6.children = new Widget[var5 + 1];
            }

            if(var6.children.length <= var5) {
               Widget[] var7 = new Widget[var5 + 1];

               for(int var8 = 0; var8 < var6.children.length; ++var8) {
                  var7[var8] = var6.children[var8];
               }

               var6.children = var7;
            }

            if(var5 > 0 && var6.children[var5 - 1] == null) {
               throw new RuntimeException("" + (var5 - 1));
            } else {
               Widget var12 = new Widget();
               var12.type = var4;
               var12.parentId = var12.id = var6.id;
               var12.index = var5;
               var12.hasScript = true;
               var6.children[var5] = var12;
               if(var2) {
                  class31.field452 = var12;
               } else {
                  class23.field366 = var12;
               }

               class7.method34(var6);
               return 1;
            }
         }
      } else {
         Widget var9;
         if(var0 == 101) {
            var9 = var2?class31.field452:class23.field366;
            Widget var10 = GZipDecompressor.method3177(var9.id);
            var10.children[var9.index] = null;
            class7.method34(var10);
            return 1;
         } else if(var0 == 102) {
            var9 = GZipDecompressor.method3177(class82.intStack[--Ignore.intStackSize]);
            var9.children = null;
            class7.method34(var9);
            return 1;
         } else if(var0 != 200) {
            if(var0 == 201) {
               var9 = GZipDecompressor.method3177(class82.intStack[--Ignore.intStackSize]);
               if(var9 != null) {
                  class82.intStack[++Ignore.intStackSize - 1] = 1;
                  if(var2) {
                     class31.field452 = var9;
                  } else {
                     class23.field366 = var9;
                  }
               } else {
                  class82.intStack[++Ignore.intStackSize - 1] = 0;
               }

               return 1;
            } else {
               return 2;
            }
         } else {
            Ignore.intStackSize -= 2;
            var3 = class82.intStack[Ignore.intStackSize];
            var4 = class82.intStack[Ignore.intStackSize + 1];
            Widget var11 = Varcs.method1849(var3, var4);
            if(var11 != null && var4 != -1) {
               class82.intStack[++Ignore.intStackSize - 1] = 1;
               if(var2) {
                  class31.field452 = var11;
               } else {
                  class23.field366 = var11;
               }
            } else {
               class82.intStack[++Ignore.intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "2032232111"
   )
   static void method1708(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < ItemComposition.field3486; ++var4) {
         ItemComposition var5 = class169.getItemDefinition(var4);
         if((!var1 || var5.field3487) && var5.notedTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               class182.field2443 = -1;
               class271.field3676 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[var2.length * 2];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      class271.field3676 = var2;
      class244.field3319 = 0;
      class182.field2443 = var3;
      String[] var8 = new String[class182.field2443];

      for(int var9 = 0; var9 < class182.field2443; ++var9) {
         var8[var9] = class169.getItemDefinition(var2[var9]).name;
      }

      short[] var10 = class271.field3676;
      MilliTimer.method2990(var8, var10, 0, var8.length - 1);
   }
}
