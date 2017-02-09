import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public class class39 {
   @ObfuscatedName("d")
   static byte[][][] field798;
   @ObfuscatedName("y")
   static final BigInteger field799 = new BigInteger("c7ad30019a1c344d954a939ec8c138934f071024875e5e8df0b1a00656d9040295760e2b07e7594cd673dfceec1e4b0b79d920d27c6d336fa03e823a59315ef2455a76713a0d96928a9edfb5d4e045d3883c9f366dbe2101914e8698eed249d129cc9cc15682d3c24f78d0b8bf6c9fa78a8bdb22fd526c3753428e9e55d19a8d", 16);
   @ObfuscatedName("iv")
   @ObfuscatedGetter(
      intValue = -48587321
   )
   static int field800;
   @ObfuscatedName("k")
   static final BigInteger field806 = new BigInteger("10001", 16);

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1121612387"
   )
   public static int method766(int var0) {
      var0 = (var0 & 1431655765) + (var0 >>> 1 & 1431655765);
      var0 = (var0 & 858993459) + (var0 >>> 2 & 858993459);
      var0 = var0 + (var0 >>> 4) & 252645135;
      var0 += var0 >>> 8;
      var0 += var0 >>> 16;
      return var0 & 255;
   }

   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-822198189"
   )
   static final void method767(int var0) {
      if(class15.method193(var0)) {
         ObjectComposition.method3639(Widget.widgets[var0], -1);
      }
   }

   class39() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "(LWidgetNode;ZI)V",
      garbageValue = "-7672971"
   )
   static final void method768(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      if(var1) {
         Ignore.method205(var2);
      }

      Item.method816(var2);
      Widget var4 = class37.method759(var3);
      if(null != var4) {
         class2.method28(var4);
      }

      class9.method124();
      if(Client.widgetRoot != -1) {
         class148.method2769(Client.widgetRoot, 1);
      }

   }
}
