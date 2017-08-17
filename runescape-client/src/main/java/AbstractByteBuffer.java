import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
@Implements("AbstractByteBuffer")
public abstract class AbstractByteBuffer {
   @ObfuscatedName("h")
   static boolean field2416;
   @ObfuscatedName("u")
   @Export("osName")
   public static String osName;

   static {
      field2416 = false;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "2040016834"
   )
   @Export("get")
   abstract byte[] get();

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BS)V",
      garbageValue = "19285"
   )
   @Export("put")
   abstract void put(byte[] var1);

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "758013495"
   )
   static final void method3407(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(Ignore.loadWidget(var0)) {
         Occluder.method2919(class176.widgets[var0], -1, var1, var2, var3, var4, var5, var6);
      }
   }
}
