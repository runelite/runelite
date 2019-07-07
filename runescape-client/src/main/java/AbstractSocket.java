import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
@Implements("AbstractSocket")
public abstract class AbstractSocket {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1765046516"
   )
   @Export("isAvailable")
   public abstract boolean isAvailable(int length) throws IOException;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1078471130"
   )
   @Export("available")
   public abstract int available() throws IOException;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "516705222"
   )
   @Export("readUnsignedByte")
   public abstract int readUnsignedByte() throws IOException;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-1089665746"
   )
   @Export("read")
   public abstract int read(byte[] dst, int dstIndex, int length) throws IOException;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-86"
   )
   @Export("write")
   public abstract void write(byte[] src, int srcIndex, int length) throws IOException;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1252618448"
   )
   @Export("close")
   public abstract void close();

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-15"
   )
   public static void method3488(int var0) {
      class214.field1129 = 1;
      class214.field1130 = null;
      class30.musicTrackGroupId = -1;
      GrandExchangeOffer.musicTrackFileId = -1;
      WorldMapLabel.field1039 = 0;
      RectangleMode.musicTrackBoolean = false;
      FaceNormal.field344 = var0;
   }
}
