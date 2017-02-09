import java.io.File;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("ge")
public class class186 extends CacheableNode {
   @ObfuscatedName("y")
   public static NodeCache field2749 = new NodeCache(64);
   @ObfuscatedName("k")
   public static class182 field2750;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1640870781
   )
   public int field2751 = 0;
   @ObfuscatedName("ex")
   static SpritePixels field2752;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1874838610"
   )
   public void method3409(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3410(var1, var2);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1104463170"
   )
   void method3410(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2751 = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "1653527244"
   )
   public static Class method3417(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Reflection.findClass(var0)))))))));
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;I)V",
      garbageValue = "1778061999"
   )
   public static void method3419(File var0) {
      class107.field1727 = var0;
      if(!class107.field1727.exists()) {
         throw new RuntimeException("");
      } else {
         class107.field1728 = true;
      }
   }
}
