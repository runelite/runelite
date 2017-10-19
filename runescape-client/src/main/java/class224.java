import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hc")
public class class224 {
   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "Let;"
   )
   @Export("socket")
   static Task socket;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I[BLfr;S)V",
      garbageValue = "-23805"
   )
   static void method4155(int var0, byte[] var1, IndexFile var2) {
      FileSystem var3 = new FileSystem();
      var3.field3200 = 0;
      var3.hash = (long)var0;
      var3.field3197 = var1;
      var3.index = var2;
      Deque var4 = class236.field3229;
      synchronized(class236.field3229) {
         class236.field3229.addFront(var3);
      }

      GroundObject.method2538();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lip;Ljava/lang/String;Ljava/lang/String;B)Lky;",
      garbageValue = "17"
   )
   public static SpritePixels method4153(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return BuildType.method4173(var0, var3, var4);
   }

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "60"
   )
   static void method4154() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         if(class46.method693(Client.menuTypes[var0])) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var1 = var0; var1 < Client.menuOptionCount - 1; ++var1) {
                  Client.menuOptions[var1] = Client.menuOptions[var1 + 1];
                  Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
                  Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
                  Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
                  Client.menuActionParams0[var1] = Client.menuActionParams0[var1 + 1];
                  Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
                  Client.field1161[var1] = Client.field1161[var1 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }
}
