import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.IOException;
import java.net.Socket;

@ObfuscatedName("fj")
@Implements("SocketSession2")
public class SocketSession2 extends AbstractSocket {
   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("indexScripts")
   static IndexData indexScripts;
   @ObfuscatedName("a")
   Socket field2156;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   RSInputSocket field2157;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   RSSocket field2155;

   SocketSession2(Socket var1, int var2, int var3) throws IOException {
      this.field2156 = var1;
      this.field2156.setSoTimeout(30000);
      this.field2156.setTcpNoDelay(true);
      this.field2156.setReceiveBufferSize(65536);
      this.field2156.setSendBufferSize(65536);
      this.field2157 = new RSInputSocket(this.field2156.getInputStream(), var2);
      this.field2155 = new RSSocket(this.field2156.getOutputStream(), var3);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1430377833"
   )
   public boolean vmethod3108(int var1) throws IOException {
      return this.field2157.method2955(var1);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   public int vmethod3083() throws IOException {
      return this.field2157.method2965();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1221609909"
   )
   public int vmethod3091() throws IOException {
      return this.field2157.method2949();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-1823409792"
   )
   public int vmethod3085(byte[] var1, int var2, int var3) throws IOException {
      return this.field2157.method2950(var1, var2, var3);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "906468650"
   )
   public void vmethod3082(byte[] var1, int var2, int var3) throws IOException {
      this.field2155.read(var1, var2, var3);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-124"
   )
   public void vmethod3081() {
      this.field2155.method3125();

      try {
         this.field2156.close();
      } catch (IOException var2) {
         ;
      }

      this.field2157.method2951();
   }

   protected void finalize() {
      this.vmethod3081();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)Lfg;",
      garbageValue = "126"
   )
   public static PacketNode method3067() {
      return PacketNode.field2436 == 0?new PacketNode():PacketNode.packetBufferNodes[--PacketNode.field2436];
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "66"
   )
   static void method3072() {
      class61.field694 = 99;
      class61.field693 = new byte[4][104][104];
      UrlRequest.field2083 = new byte[4][104][104];
      class168.field2226 = new byte[4][104][104];
      SceneMapObj.field413 = new byte[4][104][104];
      TextureProvider.field1667 = new int[4][105][105];
      class96.field1418 = new byte[4][105][105];
      class61.field696 = new int[105][105];
      class61.field697 = new int[104];
      class61.field698 = new int[104];
      class20.field310 = new int[104];
      class61.field699 = new int[104];
      BaseVarType.field28 = new int[104];
   }
}
