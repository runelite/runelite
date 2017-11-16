import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
public class class37 {
   @ObfuscatedName("x")
   static byte[][][] field474;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILfw;Liu;B)V",
      garbageValue = "-50"
   )
   static void method483(int var0, IndexFile var1, IndexData var2) {
      byte[] var3 = null;
      Deque var4 = class243.field3291;
      synchronized(class243.field3291) {
         for(FileSystem var5 = (FileSystem)class243.field3291.getFront(); var5 != null; var5 = (FileSystem)class243.field3291.getNext()) {
            if(var5.hash == (long)var0 && var1 == var5.index && var5.field3260 == 0) {
               var3 = var5.field3258;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.method4213(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method3028(var0);
         var2.method4213(var1, var0, var8, true);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Lcg;",
      garbageValue = "1484814533"
   )
   static World method478() {
      return World.field1216 < World.worldCount?class54.worldList[++World.field1216 - 1]:null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1193868149"
   )
   static void method479(int var0) {
      if(var0 != -1) {
         if(class64.loadWidget(var0)) {
            Widget[] var1 = Widget.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.field2829 != null) {
                  ScriptEvent var4 = new ScriptEvent();
                  var4.widget = var3;
                  var4.field785 = var3.field2829;
                  PlayerComposition.method3988(var4, 2000000);
               }
            }

         }
      }
   }
}
