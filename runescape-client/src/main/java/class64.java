import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
public class class64 {
   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2001617956"
   )
   static final void method1116() {
      if(class244.rssocket != null) {
         class244.rssocket.close();
         class244.rssocket = null;
      }

      class28.method231();
      class2.region.reset();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].reset();
      }

      System.gc();
      class174.method3343(2);
      Client.field1163 = -1;
      Client.field1014 = false;
      class168.method3108();
      TextureProvider.setGameState(10);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;Ljava/lang/String;Ljava/lang/String;I)[LModIcon;",
      garbageValue = "-1694823004"
   )
   public static ModIcon[] method1117(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return class25.method168(var0, var3, var4);
   }
}
