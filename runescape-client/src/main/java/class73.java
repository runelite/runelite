import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
public class class73 extends class163 {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;I)Z",
      garbageValue = "1110658456"
   )
   protected boolean vmethod3051(int var1, int var2, int var3, CollisionData var4) {
      return var2 == super.field2325 && var3 == super.field2323;
   }

   @ObfuscatedName("jg")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1443648423"
   )
   static void method1152(Buffer var0) {
      if(Client.field961 != null) {
         var0.putBytes(Client.field961, 0, Client.field961.length);
      } else {
         byte[] var1 = class37.method514();
         var0.putBytes(var1, 0, var1.length);
      }
   }
}
