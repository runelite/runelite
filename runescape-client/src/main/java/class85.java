import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
public class class85 {
   @ObfuscatedName("n")
   static final BigInteger field1300;
   @ObfuscatedName("l")
   static final BigInteger field1301;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "[Llh;"
   )
   @Export("titlemuteSprite")
   static IndexedSprite[] titlemuteSprite;

   static {
      field1300 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
      field1301 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "601286379"
   )
   public static final boolean method1958(char var0) {
      if(Character.isISOControl(var0)) {
         return false;
      } else {
         boolean var1 = var0 >= '0' && var0 <= '9' || var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
         if(var1) {
            return true;
         } else {
            char[] var2 = class315.field3923;

            int var3;
            char var4;
            for(var3 = 0; var3 < var2.length; ++var3) {
               var4 = var2[var3];
               if(var0 == var4) {
                  return true;
               }
            }

            var2 = class315.field3921;

            for(var3 = 0; var3 < var2.length; ++var3) {
               var4 = var2[var3];
               if(var0 == var4) {
                  return true;
               }
            }

            return false;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "436854383"
   )
   @Export("loadWidget")
   public static boolean loadWidget(int var0) {
      if(class250.validInterfaces[var0]) {
         return true;
      } else if(!Widget.widgetIndex.containsFile(var0)) {
         return false;
      } else {
         int var1 = Widget.widgetIndex.fileCount(var0);
         if(var1 == 0) {
            class250.validInterfaces[var0] = true;
            return true;
         } else {
            if(GZipDecompressor.widgets[var0] == null) {
               GZipDecompressor.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(GZipDecompressor.widgets[var0][var2] == null) {
                  byte[] var3 = Widget.widgetIndex.getConfigData(var0, var2);
                  if(var3 != null) {
                     GZipDecompressor.widgets[var0][var2] = new Widget();
                     GZipDecompressor.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        GZipDecompressor.widgets[var0][var2].decodeActive(new Buffer(var3));
                     } else {
                        GZipDecompressor.widgets[var0][var2].decode(new Buffer(var3));
                     }
                  }
               }
            }

            class250.validInterfaces[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1748211263"
   )
   public static void method1957() {
      while(true) {
         Deque var1 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
         FileSystem var0;
         synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
            var0 = (FileSystem)IndexStoreActionHandler.IndexStoreActionHandler_responseQueue.popFront();
         }

         if(var0 == null) {
            return;
         }

         var0.data.load(var0.index, (int)var0.hash, var0.field3358, false);
      }
   }
}
