import java.io.IOException;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
public class class161 extends class159 {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lea;"
   )
   @Export("listFetcher")
   static UrlRequest listFetcher;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Let;"
   )
   class153 field2162;
   @ObfuscatedName("g")
   Socket field2165;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lfg;"
   )
   GameSocket field2163;

   public class161(Socket var1, int var2, int var3) throws IOException {
      this.field2165 = var1;
      this.field2165.setSoTimeout(30000);
      this.field2165.setTcpNoDelay(true);
      this.field2165.setReceiveBufferSize(65536);
      this.field2165.setSendBufferSize(65536);
      this.field2162 = new class153(this.field2165.getInputStream(), var2);
      this.field2163 = new GameSocket(this.field2165.getOutputStream(), var3);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-2070343570"
   )
   public boolean vmethod3297(int var1) throws IOException {
      return this.field2162.method3182(var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "479833160"
   )
   public int vmethod3300() throws IOException {
      return this.field2162.method3183();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "91"
   )
   public int vmethod3301() throws IOException {
      return this.field2162.method3184();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BIIB)I",
      garbageValue = "-14"
   )
   public int vmethod3302(byte[] var1, int var2, int var3) throws IOException {
      return this.field2162.method3199(var1, var2, var3);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "16711680"
   )
   public void vmethod3304(byte[] var1, int var2, int var3) throws IOException {
      this.field2163.read(var1, var2, var3);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1598662762"
   )
   public void vmethod3299() {
      this.field2163.method3347();

      try {
         this.field2165.close();
      } catch (IOException var2) {
         ;
      }

      this.field2162.method3192();
   }

   protected void finalize() {
      this.vmethod3299();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lhj;B)Z",
      garbageValue = "-109"
   )
   public static boolean method3286(class230 var0) {
      return class230.field2892 == var0 || class230.field2893 == var0 || class230.field2894 == var0 || class230.field2895 == var0 || class230.field2896 == var0 || class230.field2897 == var0 || class230.field2898 == var0 || class230.field2902 == var0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Les;IIII)Z",
      garbageValue = "-1498692422"
   )
   @Export("boundingBox3DContainsMouse")
   static final boolean boundingBox3DContainsMouse(Model var0, int var1, int var2, int var3) {
      boolean var4 = class131.Viewport_containsMouse;
      if(!var4) {
         return false;
      } else {
         DynamicObject.method2026();
         int var5 = var0.centerX + var1;
         int var6 = var2 + var0.centerY;
         int var7 = var3 + var0.centerZ;
         int var8 = var0.extremeX;
         int var9 = var0.extremeY;
         int var10 = var0.extremeZ;
         int var11 = class33.field445 - var5;
         int var12 = AbstractByteBuffer.field2530 - var6;
         int var13 = class5.field28 - var7;
         return Math.abs(var11) > var8 + class218.field2692?false:(Math.abs(var12) > var9 + AttackOption.field1316?false:(Math.abs(var13) > var10 + class36.field482?false:(Math.abs(var13 * class222.field2709 - var12 * class31.field425) > var10 * AttackOption.field1316 + var9 * class36.field482?false:(Math.abs(var11 * class31.field425 - var13 * class131.field1881) > var8 * class36.field482 + var10 * class218.field2692?false:Math.abs(var12 * class131.field1881 - var11 * class222.field2709) <= var8 * AttackOption.field1316 + var9 * class218.field2692))));
      }
   }
}
