import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("h")
   public static String field1553;
   @ObfuscatedName("nu")
   @ObfuscatedGetter(
      intValue = 1637294437
   )
   static int field1554;
   @ObfuscatedName("d")
   Frame[] field1558;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "2094061577"
   )
   public boolean method1910(int var1) {
      return this.field1558[var1].field1315;
   }

   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;IZ)V",
      garbageValue = "0"
   )
   public Frames(IndexDataBase var1, IndexDataBase var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.method3305(var3);
      this.field1558 = new Frame[var6];
      int[] var7 = var1.method3304(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.getConfigData(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.method2828(); var12 != null; var12 = (FrameMap)var5.method2830()) {
            if(var12.field1455 == var11) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13 = var2.method3301(var11, 0);
            var10 = new FrameMap(var11, var13);
            var5.method2824(var10);
         }

         this.field1558[var7[var8]] = new Frame(var9, var10);
      }

   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "-11136"
   )
   static final void method1911(int var0, int var1) {
      if(Client.menuOptionCount >= 2 || Client.field351 != 0 || Client.field440) {
         int var2 = class114.method2212();
         String var3;
         if(Client.field351 == 1 && Client.menuOptionCount < 2) {
            var3 = "Use" + " " + Client.field439 + " " + "->";
         } else if(Client.field440 && Client.menuOptionCount < 2) {
            var3 = Client.field438 + " " + Client.field392 + " " + "->";
         } else {
            var3 = class13.method179(var2);
         }

         if(Client.menuOptionCount > 2) {
            var3 = var3 + class213.method4037(16777215) + " " + '/' + " " + (Client.menuOptionCount - 2) + " more options";
         }

         TextureProvider.field1192.method3957(var3, var0 + 4, var1 + 15, 16777215, 0, Client.gameCycle / 1000);
      }
   }
}
