import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
public abstract class class164 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1306514205
   )
   public int field2214;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1528758867
   )
   public int field2215;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1471865197
   )
   public int field2217;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -54074403
   )
   public int field2216;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIILfa;I)Z",
      garbageValue = "988412898"
   )
   protected abstract boolean vmethod3175(int var1, int var2, int var3, CollisionData var4);

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-98818743"
   )
   static final void method3174(int var0) {
      if(var0 >= 0) {
         int var1 = Client.menuActionParams0[var0];
         int var2 = Client.menuActionParams1[var0];
         int var3 = Client.menuTypes[var0];
         int var4 = Client.menuIdentifiers[var0];
         String var5 = Client.menuOptions[var0];
         String var6 = Client.menuTargets[var0];
         Ignore.menuAction(var1, var2, var3, var4, var5, var6, MouseInput.field714, MouseInput.field715);
      }
   }
}
