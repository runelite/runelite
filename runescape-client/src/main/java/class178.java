import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
public abstract class class178 {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1240880825
   )
   public int field2296;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1589540181
   )
   public int field2293;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1243119805
   )
   public int field2294;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 880617749
   )
   public int field2295;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIILfb;I)Z",
      garbageValue = "-1864637630"
   )
   protected abstract boolean vmethod3428(int var1, int var2, int var3, CollisionData var4);

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Liu;IIB)Lcr;",
      garbageValue = "-77"
   )
   static Script method3431(class245 var0, int var1, int var2) {
      int var3 = (var1 << 8) + var0.field2973;
      Script var5 = WorldMapType3.method233(var3, var0);
      if(var5 != null) {
         return var5;
      } else {
         int var6 = var0.field2973 + (var2 + 40000 << 8);
         var5 = WorldMapType3.method233(var6, var0);
         return var5 != null?var5:null;
      }
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-1"
   )
   static final void method3432(int var0) {
      if(var0 >= 0) {
         int var1 = Client.menuActionParams0[var0];
         int var2 = Client.menuActionParams1[var0];
         int var3 = Client.menuTypes[var0];
         int var4 = Client.menuIdentifiers[var0];
         String var5 = Client.menuOptions[var0];
         String var6 = Client.menuTargets[var0];
         PacketBuffer.menuAction(var1, var2, var3, var4, var5, var6, MouseInput.mouseLastPressedX, MouseInput.mouseLastPressedY);
      }
   }
}
