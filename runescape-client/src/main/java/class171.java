import java.io.IOException;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
public class class171 extends class169 {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "[Lbx;"
   )
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 374327103
   )
   @Export("intStackSize")
   static int intStackSize;
   @ObfuscatedName("g")
   Socket field2217;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lfz;"
   )
   class163 field2214;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lfa;"
   )
   GameSocket field2213;

   public class171(Socket var1, int var2, int var3) throws IOException {
      this.field2217 = var1;
      this.field2217.setSoTimeout(30000);
      this.field2217.setTcpNoDelay(true);
      this.field2217.setReceiveBufferSize(65536);
      this.field2217.setSendBufferSize(65536);
      this.field2214 = new class163(this.field2217.getInputStream(), var2);
      this.field2213 = new GameSocket(this.field2217.getOutputStream(), var3);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-37990145"
   )
   public boolean vmethod3407(int var1) throws IOException {
      return this.field2214.method3282(var1);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1289513265"
   )
   public int vmethod3406() throws IOException {
      return this.field2214.method3299();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-6075"
   )
   public int vmethod3405() throws IOException {
      return this.field2214.method3284();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "680375269"
   )
   public int vmethod3426(byte[] var1, int var2, int var3) throws IOException {
      return this.field2214.method3285(var1, var2, var3);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1818485286"
   )
   public void vmethod3411(byte[] var1, int var2, int var3) throws IOException {
      this.field2213.read(var1, var2, var3);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1579216827"
   )
   public void vmethod3404() {
      this.field2213.method3446();

      try {
         this.field2217.close();
      } catch (IOException var2) {
         ;
      }

      this.field2214.method3293();
   }

   protected void aav() {
      this.vmethod3404();
   }

   protected void finalize() {
      this.vmethod3404();
   }

   protected void aaw() {
      this.vmethod3404();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1996028487"
   )
   public static void method3395() {
      Widget.field2842.reset();
      Widget.Widget_cachedModels.reset();
      Widget.Widget_cachedFonts.reset();
      Widget.field2818.reset();
   }
}
