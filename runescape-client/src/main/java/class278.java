import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jt")
public class class278 {
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lid;Lid;III)Ljp;",
      garbageValue = "-1609688644"
   )
   static Font method5092(IndexDataBase var0, IndexDataBase var1, int var2, int var3) {
      if(!GroundObject.method2603(var0, var2, var3)) {
         return null;
      } else {
         byte[] var5 = var1.getConfigData(var2, var3);
         Font var4;
         if(var5 == null) {
            var4 = null;
         } else {
            Font var6 = new Font(var5, class295.field3848, class295.offsetsY, class295.field3845, class285.field3788, class115.field1599, class15.spritePixels);
            class295.field3848 = null;
            class295.offsetsY = null;
            class295.field3845 = null;
            class285.field3788 = null;
            class115.field1599 = null;
            class15.spritePixels = null;
            var4 = var6;
         }

         return var4;
      }
   }
}
