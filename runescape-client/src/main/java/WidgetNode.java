import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("bp")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("j")
   static File field781;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -560926001
   )
   @Export("id")
   int id;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 856933703
   )
   @Export("owner")
   int owner;
   @ObfuscatedName("i")
   boolean field782;

   WidgetNode() {
      this.field782 = false;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "722540266"
   )
   public static int method1155(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0:7 - var1));
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/lang/Class;",
      garbageValue = "-74"
   )
   public static Class method1157(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Reflection.findClass(var0)))))))));
   }

   @ObfuscatedName("fm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1725549875"
   )
   static final void method1156() {
      if(Client.field912 > 0) {
         class181.method3514();
      } else {
         Client.field970.method5100();
         class287.setGameState(40);
         MessageNode.field823 = Client.field952.method1954();
         Client.field952.method1953();
      }
   }
}
