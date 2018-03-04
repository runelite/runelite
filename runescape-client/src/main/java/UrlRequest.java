import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
@Implements("UrlRequest")
public class UrlRequest {
   @ObfuscatedName("r")
   static byte[][][] field2107;
   @ObfuscatedName("d")
   @Export("url")
   final URL url;
   @ObfuscatedName("z")
   @Export("isDone0")
   volatile boolean isDone0;
   @ObfuscatedName("n")
   @Export("response0")
   volatile byte[] response0;

   UrlRequest(URL var1) {
      this.url = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-675153140"
   )
   @Export("isDone")
   public boolean isDone() {
      return this.isDone0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "959377265"
   )
   @Export("getResponse")
   public byte[] getResponse() {
      return this.response0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljk;I)V",
      garbageValue = "1928777713"
   )
   public static void method3183(IndexDataBase var0) {
      InvType.field3443 = var0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILct;ZI)I",
      garbageValue = "-33130682"
   )
   static int method3184(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 100) {
         class81.intStackSize -= 3;
         var3 = class81.intStack[class81.intStackSize];
         var4 = class81.intStack[class81.intStackSize + 1];
         int var5 = class81.intStack[class81.intStackSize + 2];
         if(var4 == 0) {
            throw new RuntimeException();
         } else {
            Widget var6 = class5.getWidget(var3);
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
                  class20.field338 = var12;
               } else {
                  class81.field1267 = var12;
               }

               class171.method3363(var6);
               return 1;
            }
         }
      } else {
         Widget var9;
         if(var0 == 101) {
            var9 = var2?class20.field338:class81.field1267;
            Widget var10 = class5.getWidget(var9.id);
            var10.children[var9.index] = null;
            class171.method3363(var10);
            return 1;
         } else if(var0 == 102) {
            var9 = class5.getWidget(class81.intStack[--class81.intStackSize]);
            var9.children = null;
            class171.method3363(var9);
            return 1;
         } else if(var0 != 200) {
            if(var0 == 201) {
               var9 = class5.getWidget(class81.intStack[--class81.intStackSize]);
               if(var9 != null) {
                  class81.intStack[++class81.intStackSize - 1] = 1;
                  if(var2) {
                     class20.field338 = var9;
                  } else {
                     class81.field1267 = var9;
                  }
               } else {
                  class81.intStack[++class81.intStackSize - 1] = 0;
               }

               return 1;
            } else {
               return 2;
            }
         } else {
            class81.intStackSize -= 2;
            var3 = class81.intStack[class81.intStackSize];
            var4 = class81.intStack[class81.intStackSize + 1];
            Widget var11 = class197.getWidgetChild(var3, var4);
            if(var11 != null && var4 != -1) {
               class81.intStack[++class81.intStackSize - 1] = 1;
               if(var2) {
                  class20.field338 = var11;
               } else {
                  class81.field1267 = var11;
               }
            } else {
               class81.intStack[++class81.intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }
}
