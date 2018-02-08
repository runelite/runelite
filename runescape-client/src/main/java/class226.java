import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hd")
public class class226 {
   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   @Export("loginType")
   static JagexLoginType loginType;

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      signature = "(Lcj;III)V",
      garbageValue = "-1189389704"
   )
   static final void method4410(ContextMenuRow var0, int var1, int var2) {
      Client.menuAction(var0.param0, var0.param1, var0.type, var0.identifier, var0.option, var0.option, var1, var2);
   }
}
