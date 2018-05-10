import java.lang.management.GarbageCollectorMXBean;
import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("bz")
public class class76 {
   @ObfuscatedName("w")
   static final BigInteger field1093;
   @ObfuscatedName("m")
   static final BigInteger field1087;
   @ObfuscatedName("a")
   public static short[][] field1091;
   @ObfuscatedName("ab")
   protected static GarbageCollectorMXBean field1092;

   static {
      field1093 = new BigInteger("10001", 16);
      field1087 = new BigInteger("a0be39298d552cd768de266917d1b5520dba6db5152e2fc6928eb3070e3d2644f84aee395e32ac18e4e44722440ceed6e1164dc39d8619feb2ca6eda3081876a39c374f1588a22a85c8f246293bc4e62441d1453209b5ae18c8ccb4e40fb85116ad91261589b2991643d8e84b595ccb7b95b19c93a2876f669ec1e0a5bb30d83", 16);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "-1305416058"
   )
   public static char method1850(char var0) {
      return (char)(var0 == 198?69:(var0 == 230?101:(var0 == 223?115:(var0 == 338?69:(var0 == 339?'e':'\u0000')))));
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/lang/Class;",
      garbageValue = "8"
   )
   @Export("loadClassFromDescriptor")
   public static Class loadClassFromDescriptor(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Reflection.findClass(var0)))))))));
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "934914920"
   )
   public static void method1851() {
      try {
         class155.dat2File.close();

         for(int var0 = 0; var0 < class155.idxCount; ++var0) {
            class155.idxFiles[var0].close();
         }

         class155.idx255File.close();
         class155.randomDat.close();
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("je")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1671718269"
   )
   static final void method1849(int var0, int var1) {
      if(GameCanvas.loadWidget(var0)) {
         WorldComparator.method2(Widget.widgets[var0], var1);
      }
   }

   @ObfuscatedName("ke")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "1257304632"
   )
   static void method1852(Buffer var0, int var1) {
      byte[] var2 = var0.payload;
      if(Client.field718 == null) {
         Client.field718 = new byte[24];
      }

      class193.method3951(var2, var1, Client.field718, 0, 24);
      class187.method3855(var0, var1);
   }
}
