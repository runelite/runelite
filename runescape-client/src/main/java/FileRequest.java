import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jb")
@Implements("FileRequest")
public class FileRequest extends CacheableNode {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("index")
   IndexData index;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1441835589
   )
   @Export("crc")
   int crc;
   @ObfuscatedName("b")
   @Export("padding")
   byte padding;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Ljl;",
      garbageValue = "-852112309"
   )
   public static class281 method4638(int var0) {
      class281 var1 = (class281)class281.field3568.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class281.field3576.getConfigData(32, var0);
         var1 = new class281();
         if(var2 != null) {
            var1.method5044(new Buffer(var2));
         }

         class281.field3568.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("jq")
   @ObfuscatedSignature(
      signature = "([Liz;II)V",
      garbageValue = "1433926302"
   )
   static final void method4639(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var3.parentId == var1 && (!var3.hasScript || !MapIconReference.method762(var3))) {
            if(var3.type == 0) {
               if(!var3.hasScript && MapIconReference.method762(var3) && var3 != GameCanvas.field642) {
                  continue;
               }

               method4639(var0, var3.id);
               if(var3.children != null) {
                  method4639(var3.children, var3.id);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var4 != null) {
                  UnitPriceComparator.method142(var4.id);
               }
            }

            if(var3.type == 6) {
               int var5;
               if(var3.field2868 != -1 || var3.field2869 != -1) {
                  boolean var7 = UrlRequest.method3182(var3);
                  if(var7) {
                     var5 = var3.field2869;
                  } else {
                     var5 = var3.field2868;
                  }

                  if(var5 != -1) {
                     Sequence var6 = NPC.getAnimation(var5);

                     for(var3.field2896 += Client.field913; var3.field2896 > var6.frameLengths[var3.field2943]; TotalQuantityComparator.method100(var3)) {
                        var3.field2896 -= var6.frameLengths[var3.field2943];
                        ++var3.field2943;
                        if(var3.field2943 >= var6.frameIDs.length) {
                           var3.field2943 -= var6.frameStep;
                           if(var3.field2943 < 0 || var3.field2943 >= var6.frameIDs.length) {
                              var3.field2943 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2907 != 0 && !var3.hasScript) {
                  int var8 = var3.field2907 >> 16;
                  var5 = var3.field2907 << 16 >> 16;
                  var8 *= Client.field913;
                  var5 *= Client.field913;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  TotalQuantityComparator.method100(var3);
               }
            }
         }
      }

   }
}
