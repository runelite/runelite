import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("WallObject")
public final class class90 {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1893481543
   )
   int field1599;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1886146803
   )
   @Export("x")
   int field1600;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1113690545
   )
   int field1601;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1016002769
   )
   @Export("floor")
   int field1603;
   @ObfuscatedName("l")
   @Export("renderable1")
   public class88 field1604;
   @ObfuscatedName("j")
   @Export("renderable2")
   public class88 field1605;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 398841471
   )
   @Export("hash")
   public int field1606 = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -804685195
   )
   int field1607 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -866522957
   )
   @Export("y")
   int field1609;
   @ObfuscatedName("br")
   static class83[] field1610;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-171055632"
   )
   public static void method2159(Component var0) {
      var0.setFocusTraversalKeysEnabled(false);
      var0.addKeyListener(class140.field2189);
      var0.addFocusListener(class140.field2189);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-843654338"
   )
   public static void method2160(Component var0) {
      var0.removeKeyListener(class140.field2189);
      var0.removeFocusListener(class140.field2189);
      class140.field2177 = -1;
   }
}
